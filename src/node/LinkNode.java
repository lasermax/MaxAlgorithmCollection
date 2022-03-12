package node;

public class LinkNode<T> extends Node<T> {

    private LinkNode<T> successor;

    public LinkNode() {
        super();
    }

    public LinkNode(T data) {
        super(data);
    }

    public LinkNode(LinkNode<T> successor) {
        setSuccessor(successor);
    }

    public LinkNode(T data, LinkNode<T> successor) {
        super(data);
        setSuccessor(successor);
    }

    public LinkNode<T> getSuccessor() {
        return successor;
    }

    public void setSuccessor(LinkNode<T> successor) {
        this.successor = successor;
    }

}
