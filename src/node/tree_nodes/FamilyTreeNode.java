package node.tree_nodes;

import java.util.ArrayList;

public class FamilyTreeNode<T> extends TreeNode<T> {

    private final ArrayList<FamilyTreeNode<T>> children = new ArrayList<>();

    public FamilyTreeNode() {
        super();
    }

    public FamilyTreeNode(T data) {
        super(data);
    }

    public FamilyTreeNode(FamilyTreeNode<T>[] children) {
        super();
        addChildren(children);
    }

    public FamilyTreeNode(T data, FamilyTreeNode<T>[] children) {
        super(data);
        addChildren(children);
    }

    public FamilyTreeNode<T>[] getChildren() {
        if (this.children.size() == 0) {
            return null;
        }
        return this.children.toArray(new FamilyTreeNode[0]);
    }

    @SafeVarargs
    public final void addChildren(FamilyTreeNode<T>... children) {
        for (FamilyTreeNode<T> child : children) {
            addChild(child);
        }
    }

    public void addChild(FamilyTreeNode<T> child) {
        this.children.add(child);
        child.setParent(this);
    }

}
