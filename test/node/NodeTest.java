package node;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    @DisplayName("getter and setter change member variable")
    void getterAndSetterChangeMemberVariable() {
        Node<String> node = new Node<>("Test");
        assertEquals("Test", node.getData());
        node.setData("Test2");
        assertEquals("Test2", node.getData());
    }

    @Test
    @DisplayName("Data is initialized with null")
    void dataIsInitializedWithNull() {
        Node<Integer> node = new Node<>();
        assertThrows(NullPointerException.class, () -> {
            node.getData().toString();
        });

    }

}