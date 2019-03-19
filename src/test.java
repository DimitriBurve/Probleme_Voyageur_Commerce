import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addNode(n2);
        n1.addNode(n3);
        n1.addNode(n4);
        n2.addNode(n4);
        n2.addNode(n3);
        n3.addNode(n4);

        List<Edge> listEdges = new ArrayList<Edge>();
        Edge n1ToN2 = new Edge(n1, n2, 4);
        Edge n1ToN3 = new Edge(n1, n3, 3);
        Edge n1ToN4 = new Edge(n1, n4, 1);

        Edge n2ToN1 = new Edge(n2, n1, 4);
        Edge n2ToN3 = new Edge(n2, n3, 1);
        Edge n2ToN4 = new Edge(n2, n4, 2);

        Edge n3ToN1 = new Edge(n3, n1, 3);
        Edge n3ToN2 = new Edge(n3, n2, 1);
        Edge n3ToN4 = new Edge(n3, n4, 5);

        Edge n4ToN1 = new Edge(n4, n1, 1);
        Edge n4ToN2 = new Edge(n4, n2, 2);
        Edge n4ToN3 = new Edge(n4, n3, 5);

        listEdges.add(n1ToN2);
        listEdges.add(n1ToN3);
        listEdges.add(n1ToN4);
        listEdges.add(n2ToN1);
        listEdges.add(n2ToN3);
        listEdges.add(n2ToN4);
        listEdges.add(n3ToN1);
        listEdges.add(n3ToN2);
        listEdges.add(n3ToN4);
        listEdges.add(n4ToN1);
        listEdges.add(n4ToN2);
        listEdges.add(n4ToN3);

        Graph g1 = new Graph();
        g1.addNode(n1);
        g1.addNode(n2);
        g1.addNode(n3);
        g1.addNode(n4);
        g1.addListEdges(listEdges);

        connexe(g1, n1);

        //enleve le marquage des noeuds du graphe
        g1.marqueFalseNodes();

        g1.addListNodes(initialisation(g1,n1));

        for (Node node : g1.getListNodes()){
            System.out.println("node :"+node.getId()+", value : "+node.getValue());
        }

        for (Edge edge : g1.getListEdges()){
            System.out.println("edge : " + edge.getN1().getId()+" to "+ edge.getN2().getId()+ ", poids : "+ edge.getValue());
        }


        calcule(g1, n1, n1);
    }

    public static void connexe(Graph graph, Node node){
        List<Node> children = node.getChildren();
        node.setMarque(true);
        System.out.println("noeud n°"+node.getId());
        for (Node fils: children){
            if (!fils.isMarque()){
                connexe(graph, fils);
            }
        }
    }

    public static List<Node> initialisation(Graph g, Node nodeDebut){
        List<Node> listApresInit = g.getListNodes();
        for (Node node: listApresInit){
            if (node == nodeDebut){
                node.setValue(0);
            }else{
                node.setValue(9999999);
            }
        }
        return listApresInit;
    }

    public static Node trouve_min(Graph g){
        int mini = 9999999;
        Node sommet = null;
        for (Node node: g.getListNodes()){
            if (node.getValue() < mini){
                mini = node.getValue();
                sommet = node;
            }
        }
        return sommet;
    }

    public static void maj_distances(Graph g1, Node n1, Node n2){
        if (n2.getValue() > n1.getValue() + g1.poids(n1, n2)){
            System.out.println("valeur de "+n1.getId()+" : "+ n1.getValue());
            System.out.println(" valeur de edge : "+ g1.poids(n1,n2));
            n2.setValue(n1.getValue() + g1.poids(n1,n2));
            System.out.println("nouvelle valeur de "+ n2.getId() +" : "+ n2.getValue());
            n2.setPredecesseur(n1);
        }
    }

    public static void calcule(Graph g, Node nodeDebut, Node nodeFin){
        initialisation(g, nodeDebut);
        Node n1;
        Graph q = g;
        List<Node> listResult = new ArrayList<Node>();
        while (q.getListNodes().size() != 0){
            n1 = trouve_min(q);
            System.out.println("min : "+n1.getId());
            listResult.add(n1);
            q = q.deleteNode(n1);
            for (Node n2 : n1.getChildren()){
                System.out.println("fils de min : "+n2.getId());
                maj_distances(g, n1, n2);
                if (n2.getPredec() != null) {
                    System.out.println("predec de fils : " + n2.getPredec().getId());
                }
            }
        }

        Node s = nodeFin;
        System.out.println("node s :" + s.getId());
        while (s != nodeDebut){
            listResult.add(s);
            System.out.println(s.getId());
            s = s.getPredec();
            System.out.println(s.getId());
        }
        listResult.add(s);
        System.out.println("parcours :");
        for (Node node : listResult){
            System.out.println(node.getId());
        }
    }
}
