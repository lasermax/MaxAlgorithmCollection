package stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ResizeableStackTest{
    @Test
    void resize() {
        ResizeableStack<Integer> stack = new ResizeableStack<>(4);
        assertEquals(4, stack.maxSize());
        stack.resize(9);
        assertEquals(9, stack.maxSize());
        stack.push(5);
        stack.push(4);
        stack.push(2);
        assertEquals(Arrays.toString(new Integer[]{5,4,2, null, null, null, null,null,null}), Arrays.toString(stack.stackArray));
        assertThrows(IllegalArgumentException.class, () -> {
            stack.resize(2);
        });
        stack.resize(3);
        assertEquals(Arrays.toString(new Integer[]{5,4,2}), Arrays.toString(stack.stackArray));

    }

}