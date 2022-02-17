package stack;

import org.junit.jupiter.api.Test;
import stack.StandardStack;

import static org.junit.jupiter.api.Assertions.*;

class StandardStackTest {

    @Test
    void pop() {
        StandardStack<Integer> stack = new StandardStack<>(15);
        assertThrows(IllegalStateException.class, stack::pop);

        stack.push(12);
        stack.push(14);

        assertEquals(14, stack.pop());
        assertEquals(12, stack.pop());
    }

    @Test
    void push() {
        StandardStack<Integer> stack = new StandardStack<>(2);

        stack.push(5);
        stack.push(3);

        assertThrows(IllegalStateException.class, () -> {
            stack.push(4);
        });
    }

    @Test
    void maxSize() {
        StandardStack<Integer> stack = new StandardStack<>(15);
        assertEquals(15, stack.maxSize());

        stack = new StandardStack<>();
        assertEquals(10, stack.maxSize());

        stack.push(8);
        assertEquals(10, stack.maxSize());

    }

    @Test
    void size() {
        StandardStack<Integer> stack = new StandardStack<>(15);
        assertEquals(0, stack.size());

        stack.push(8);
        assertEquals(1, stack.size());
        stack.push(7);
        stack.push(9);
        assertEquals(3, stack.size());
    }

    @Test
    void isEmpty() {
        StandardStack<Integer> stack = new StandardStack<>(12);
        assertTrue(stack.isEmpty());
        stack.push(5);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void isFull() {
        StandardStack<Integer> stack = new StandardStack<>(2);
        assertFalse(stack.isFull());
        stack.push(5);
        assertFalse(stack.isFull());
        stack.push(4);
        assertTrue(stack.isFull());
        stack.pop();
        assertFalse(stack.isFull());

    }
}