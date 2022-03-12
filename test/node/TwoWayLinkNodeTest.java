package node;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoWayLinkNodeTest {

    @Test
    @DisplayName("Data Constructor sets Data and rest is null")
    void dataConstructorSetsDataAndRestIsNull() {
        TwoWayLinkNode<String> twoWayLinkNode = new TwoWayLinkNode<>("Test");

        assertEquals("Test", twoWayLinkNode.getData());
        assertNull(twoWayLinkNode.getSuccessor());
        assertNull(twoWayLinkNode.getPredecessor());
    }

    @Test
    @DisplayName("Data / Successor sets both and Predecessor is null")
    void dataSuccessorSetsBothAndPredecessorIsNull() {
        TwoWayLinkNode<String> twoWayLinkNode = new TwoWayLinkNode<>("Test", new TwoWayLinkNode<>());

        assertEquals("Test", twoWayLinkNode.getData());
        assertNotNull(twoWayLinkNode.getSuccessor());
        assertNull(twoWayLinkNode.getPredecessor());
    }

    @Test
    @DisplayName("All Constructor sets all")
    void allConstructorSetsAll() {
        TwoWayLinkNode<String> twoWayLinkNode = new TwoWayLinkNode<>("Test", new TwoWayLinkNode<>(), new TwoWayLinkNode<>());

        assertEquals("Test", twoWayLinkNode.getData());
        assertNotNull(twoWayLinkNode.getSuccessor());
        assertNotNull(twoWayLinkNode.getPredecessor());
    }

    @Test
    @DisplayName("Two way Propagation works")
    void twoWayPropagationWorks() {
        TwoWayLinkNode<String> first = new TwoWayLinkNode<>("Data1");
        TwoWayLinkNode<String> second = new TwoWayLinkNode<>("Data2");
        TwoWayLinkNode<String> third = new TwoWayLinkNode<>("Data3");
        TwoWayLinkNode<String> fourth = new TwoWayLinkNode<>("Data4");

        TwoWayLinkNode.connect(first, second);
        TwoWayLinkNode.connect(second, third);
        TwoWayLinkNode.connect(third, fourth);

        assertEquals(second, first.getSuccessor());
        assertEquals(third, fourth.getPredecessor());
        assertEquals("Data2",first.getSuccessor().getSuccessor().getPredecessor().getData());
    }

    @Test
    @DisplayName("Check Successor Argument Type")
    void checkSuccessorArgumentType() {
        TwoWayLinkNode<String> twoWayLinkNode = new TwoWayLinkNode<>();
        TwoWayLinkNode<String> successor = new TwoWayLinkNode<>();
        LinkNode<String> badSuccessor = new LinkNode<>();

        twoWayLinkNode.setSuccessor(successor);

        assertThrows(IllegalArgumentException.class, () -> {
            twoWayLinkNode.setSuccessor(badSuccessor);
        });

    }
}