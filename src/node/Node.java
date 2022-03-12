package node;

public class Node<T> {

    private T data;

    public Node() {}

    public Node(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
