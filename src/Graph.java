import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> listNodes = new ArrayList<Node>();
    private List<Edge> listEdges = new ArrayList<Edge>();

    public Graph(){}

    public void addNode(Node node){
        listNodes.add(node);
    }

    public void addListNodes(List<Node> listNodes){
        this.listNodes=listNodes;
    }

    public void addListEdges(List<Edge> listEdges){
        this.listEdges = listEdges;
    }

    public void addEdge(Edge edge){
        listEdges.add(edge);
    }

    public List<Node> getListNodes(){
        return listNodes;
    }

    public List<Edge> getListEdges(){
        return listEdges;
    }

    public int getTailleListeNodes(){
        return listNodes.size();
    }

    public int getTailleListeEdges(){
        return listEdges.size();
    }

    public void marqueTrueNodes(){
        for (Node node: listNodes){
            node.setMarque(true);
        }
    }

    public void marqueFalseNodes(){
        for (Node node: listNodes){
            node.setMarque(false);
        }
    }

    public int poids(Node n1, Node n2){
        int poids=9999999;
        for (Edge edge : this.listEdges){
            if (edge.getN1()==n1 && edge.getN2()==n2){
                poids = edge.getValue();
            }
        }
        return poids;
    }

    public Graph deleteNode(Node node){
        listNodes.remove(node);
        return this;
    }

    public Edge minSearch(List<Edge> list){
        int value = 999999999;
        Edge edge = null;
        for (int i=0; i<list.size();i++){
            if (list.get(i).getValue()<value){
                value = list.get(i).getValue();
                edge = list.get(i);
            }
        }
        return edge;
    }

    public Edge searchEdgeFromN1AndN2(Node n1, Node n2){
        Edge edge = null;
        for (Edge e: listEdges){
            if (e.getN1() == n1 && e.getN2() == n2){
                edge = e;
            }
        }
        return edge;
    }

    public List<Edge> foundAllEdgeN1(Node n1){
        List<Edge> list = new ArrayList<>();
        for (Edge e: listEdges){
            if ((e.getN1() == n1 ) || (e.getN2() == n1 )){
                list.add(e);
            }
        }
        return list;
    }
}
