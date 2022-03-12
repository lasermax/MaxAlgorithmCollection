package node.tree_nodes;

public class BinaryTreeNode<T> extends TreeNode<T> {

    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {
        super();
    }

    public BinaryTreeNode(T data) {
        super(data);
    }

    public BinaryTreeNode(BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        super();
        setLeftChild(leftChild);
        setRightChild(rightChild);
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        super(data);
        setLeftChild(leftChild);
        setRightChild(rightChild);
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
        leftChild.setParent(this);
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
        rightChild.setParent(this);
    }

    public void setChildren(BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        setLeftChild(leftChild);
        setRightChild(rightChild);
    }

    @Override
    public BinaryTreeNode<T> getParent() {
        return (BinaryTreeNode<T>)super.getParent();
    }
}
