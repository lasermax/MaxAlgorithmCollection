package stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AutoResizeableStackTest{

    @Test
    void autoResize() {
        AutoResizeableStack<Integer> stack = new AutoResizeableStack<>(3);
        assertEquals(3,stack.maxSize());
        stack.push(3);
        stack.push(3);
        stack.push(2);
        stack.push(3);
        assertEquals(4, stack.size());
        assertEquals(8, stack.maxSize());
        assertEquals(Arrays.toString(new Integer[]{3,3,2,3,null,null,null,null}), Arrays.toString(stack.stackArray));


    }

}