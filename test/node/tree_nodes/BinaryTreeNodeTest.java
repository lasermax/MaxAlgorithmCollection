package node.tree_nodes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @Test
    @DisplayName("Empty Constructor does not initialize anything")
    void emptyConstructorDoesNotInitializeAnything() {
        BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<>();

        assertNull(binaryTreeNode.getData());

        assertNull(binaryTreeNode.getLeftChild());
        assertNull(binaryTreeNode.getRightChild());
        assertNull(binaryTreeNode.getParent());
    }

    @Test
    @DisplayName("Data Constructor only initializes data")
    void dataConstructorOnlyInitializesData() {
        BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<>("Test1");

        assertEquals("Test1", binaryTreeNode.getData());

        assertNull(binaryTreeNode.getLeftChild());
        assertNull(binaryTreeNode.getRightChild());
        assertNull(binaryTreeNode.getParent());
    }

    @Test
    @DisplayName("Children Constructor only initializes children")
    void childrenConstructorOnlyInitializesChildren() {
        BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<>(new BinaryTreeNode<>(), new BinaryTreeNode<>());

        assertNull(binaryTreeNode.getData());

        assertNotNull(binaryTreeNode.getLeftChild());
        assertNotNull(binaryTreeNode.getRightChild());
        assertNull(binaryTreeNode.getParent());
    }

    @Test
    @DisplayName("Complete Constructor initializes all members")
    void completeConstructorInitializesAllMembers() {
        BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<>("Test1", new BinaryTreeNode<>(), new BinaryTreeNode<>());

        assertEquals("Test1", binaryTreeNode.getData());

        assertNotNull(binaryTreeNode.getLeftChild());
        assertNotNull(binaryTreeNode.getRightChild());
        assertNull(binaryTreeNode.getParent());
    }

    @Test
    @DisplayName("Propagation to Children and back works")
    void propagationToChildrenAndBackWorks() {
        BinaryTreeNode<String> binaryTreeNode = new BinaryTreeNode<>("Parent");

        BinaryTreeNode<String> leftChild = new BinaryTreeNode<>("Left Child");
        BinaryTreeNode<String> rightChild = new BinaryTreeNode<>("Right Child");

        binaryTreeNode.setChildren(leftChild, rightChild);

        assertEquals("Left Child", binaryTreeNode.getLeftChild().getData());
        assertEquals("Right Child", binaryTreeNode.getRightChild().getData());

        assertEquals("Parent", binaryTreeNode.getLeftChild().getParent().getRightChild().getParent().getData());
    }

}