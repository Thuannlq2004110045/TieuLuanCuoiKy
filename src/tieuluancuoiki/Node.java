package tieuluancuoiki;

public class Node {
    HangHoa data;
    Node next;
    Node prev;

    public Node(){};

    public Node(HangHoa d){
        data = d;
        next = null;
        prev = null;
    }

    public Node(HangHoa d, Node n, Node p){
        data = d;
        next = n;
        prev = p;
    }
}
