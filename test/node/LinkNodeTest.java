package node;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkNodeTest {

    @Test
    @DisplayName("Data Constructor sets Data and does not set successor")
    void dataConstructorSetsDataAndDoesNotSetSuccessor() {
        LinkNode<String> linkNode = new LinkNode<>("Test");

        assertEquals("Test", linkNode.getData());
        assertNull(linkNode.getSuccessor());
    }

    @Test
    @DisplayName("Successor Constructor sets Successor and does not set data")
    void successorConstructorSetsSuccessorAndDoesNotSetData() {
        LinkNode<Integer> linkNode = new LinkNode<>(new LinkNode<>(14));

        assertNotNull(linkNode.getSuccessor());
        assertNull(linkNode.getData());
    }

    @Test
    @DisplayName("Successor Data Constructor sets both")
    void successorDataConstructorSetsBoth() {
        LinkNode<String> linkNode = new LinkNode<>("Test", new LinkNode<>("Test"));

        assertEquals("Test", linkNode.getData());
        assertNotNull(linkNode.getSuccessor());
    }

    @Test
    @DisplayName("Propagation to Successor works and getters/setters")
    void propagationToSuccessorWorks() {
        LinkNode<String> linkNode = new LinkNode<>();
        linkNode.setSuccessor(new LinkNode<>("Node2", new LinkNode<>("Node3")));
        linkNode.setData("Node1");

        assertEquals("Node1", linkNode.getData());
        assertEquals("Node2", linkNode.getSuccessor().getData());
        assertEquals("Node3", linkNode.getSuccessor().getSuccessor().getData());
    }

}