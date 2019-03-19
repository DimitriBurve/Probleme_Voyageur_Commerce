import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private List<Node> children = new ArrayList<Node>();
    private int value;
    private boolean isMarque;
    private Node predec;

    public Node(int id){
        this.id = id;
        this.isMarque = false;
//        this.value=-1;
    }

    public void addNode(Node node){
        children.add(node);
    }

    public boolean hasChildren(){
        return children.size()>0;
    }

    public List<Node> getChildren(){
        return children;
    }

    public int getId(){
        return this.id;
    }

    public void setMarque(boolean bool){
        this.isMarque = bool;
    }

    public boolean isMarque(){
        return this.isMarque;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){ return this.value; }

    public void setPredecesseur(Node node){ predec= node; }

    public Node getPredec(){ return this.predec; }
}
