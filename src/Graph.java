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
}
