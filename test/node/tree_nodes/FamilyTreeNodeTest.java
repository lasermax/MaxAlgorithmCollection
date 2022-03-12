package node.tree_nodes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTreeNodeTest {

    FamilyTreeNode<String>[] familyTreeNodeArray = new FamilyTreeNode[] {
            new FamilyTreeNode<>("Node1"),
            new FamilyTreeNode<>("Node2"),
            new FamilyTreeNode<>("Node3"),
            new FamilyTreeNode<>("Node4")
    };

    @Test
    @DisplayName("Default Constructor does not initialize anything")
    void defaultConstructorDoesNotInitializeAnything() {
        FamilyTreeNode<String> familyTreeNode = new FamilyTreeNode<>();

        assertNull(familyTreeNode.getData());
        assertNull(familyTreeNode.getParent());
        assertNull(familyTreeNode.getChildren());
    }

    @Test
    @DisplayName("Data Constructor only initializes Data Member")
    void dataConstructorOnlyInitializesDataMember() {
        FamilyTreeNode<String> familyTreeNode = new FamilyTreeNode<>("Node");

        assertEquals("Node", familyTreeNode.getData());
        assertNull(familyTreeNode.getParent());
        assertNull(familyTreeNode.getChildren());
    }

    @Test
    @DisplayName("Children Constructor only initializes Children Member")
    void childrenConstructorOnlyInitializesChildrenMember() {
        FamilyTreeNode<String> familyTreeNode = new FamilyTreeNode<>(familyTreeNodeArray);

        assertNull(familyTreeNode.getData());
        assertNull(familyTreeNode.getParent());
        assertNotNull(familyTreeNode.getChildren());
    }

    @Test
    @DisplayName("Complete Constructor initializes all Fields")
    void completeConstructorInitializesAllFields() {
        FamilyTreeNode<String> familyTreeNode = new FamilyTreeNode<>("Test", familyTreeNodeArray);

        assertEquals("Test", familyTreeNode.getData());
        assertNull(familyTreeNode.getParent());
        assertNotNull(familyTreeNode.getChildren());
    }

    @Test
    @DisplayName("Propagation to Children works")
    void propagationToChildrenWorks() {
        FamilyTreeNode<String> familyTreeNode = new FamilyTreeNode<>("Parent", familyTreeNodeArray);

        for (FamilyTreeNode<String> node : familyTreeNode.getChildren()) {
            assertEquals("Parent", node.getParent().getData());
        }
    }
}