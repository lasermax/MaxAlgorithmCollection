package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("BaseStack")
class BaseStackTest {

    @Test
    @DisplayName("should be able to push and pop elements")
    void shouldBeAbleToPushAndPopElements() {
        BaseStack<String> stack = new BaseStack<>(15);

        stack.push("Test1");
        stack.push("Test2");
        assertEquals(2, stack.size());
        assertEquals("Test2", stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("should have size two with two parameters of type")
    void shouldHaveSizeTwoWithTwoParametersOfType() {
        BaseStack<Integer> stack = new BaseStack<>(10, 5, 6);

        assertEquals(2, stack.size());
    }

}