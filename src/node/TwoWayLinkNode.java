package node;

public class TwoWayLinkNode<T> extends LinkNode<T> {

    private TwoWayLinkNode<T> predecessor;

    public TwoWayLinkNode() {}

    public TwoWayLinkNode(T data) {
        super(data);
    }

    public TwoWayLinkNode(T data, TwoWayLinkNode<T> successor) {
        super(data, successor);
    }

    public TwoWayLinkNode(T data, TwoWayLinkNode<T> successor, TwoWayLinkNode<T> predecessor) {
        super(data, successor);
        setPredecessor(predecessor);
    }

    public static <E> void connect(TwoWayLinkNode<E> predecessor, TwoWayLinkNode<E> successor) {
        predecessor.setSuccessor(successor);
        successor.setPredecessor(predecessor);
    }

    public TwoWayLinkNode<T> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(TwoWayLinkNode<T> predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public TwoWayLinkNode<T> getSuccessor() {
        return (TwoWayLinkNode<T>)super.getSuccessor();
    }

    @Override
    @Deprecated
    public void setSuccessor(LinkNode<T> successor) {
        throw new IllegalArgumentException("Type of successor must be TwoWayLinkNode instead of LinkNode");
    }

    public void setSuccessor(TwoWayLinkNode<T> successor) {
        super.setSuccessor(successor);
    }
}
