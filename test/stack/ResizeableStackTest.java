package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizeableStackTest {
    @Test
    @DisplayName("throws error with a size smaller than the current number of elements")
    void throwsErrorWithASizeSmallerThanTheCurrentNumberOfElements() {
        ResizeableStack<String> stack = new ResizeableStack<>(3, "Test1", "Test2", "Test3");
        assertThrows(IllegalArgumentException.class, () -> stack.resize(2), "Size can not be smaller then the number of elements on the stack");

        assertThrows(IllegalArgumentException.class, () -> stack.resize(-5), "Size can not be smaller then the number of elements on the stack");

        stack.pop();
        stack.resize(2);
    }

    @Test
    @DisplayName("correct size change")
    void correctSizeChange() {
        ResizeableStack<String> stack = new ResizeableStack<>(3, "Test1", "Test2", "Test3");

        assertEquals(3, stack.stack.length);
        stack.resize(15);
        assertEquals(15, stack.stack.length);

    }
}