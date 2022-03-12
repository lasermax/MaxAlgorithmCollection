package node.tree_nodes;

import node.Node;

public abstract class TreeNode<T> extends Node<T> {

    private TreeNode<T> parent;

    public TreeNode() {
        super();
    }

    public TreeNode(T data) {
        super(data);
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    protected void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }
}
