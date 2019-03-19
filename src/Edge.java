public class Edge {
    private Node n1;
    private Node n2;
    private int value;

    public Edge(Node n1, Node n2, int value){
        this.n1 = n1;
        this.n2 = n2;
        this.value = value;
    }

    public Node getN1(){
        return n1;
    }

    public Node getN2(){
        return n2;
    }

    public int getValue(){
        return value;
    }
}
