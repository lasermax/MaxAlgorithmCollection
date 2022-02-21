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

    @Test
    @DisplayName("isEmpty returns correct result after removing all items")
    void isEmptyReturnsCorrectResultAfterRemovingAllItems() {
        BaseStack<String> stack = new BaseStack<>(new String[]{"Test", "Test2"});
        assertEquals("Test2", stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals("Test", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("size returns correct results")
    void sizeReturnsCorrectResults() {
        BaseStack<Integer> stack = new BaseStack<>(10, 5, 6);

        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        stack.push(5);
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("correct STD_SIZE with no parameter constructor")
    void correctStdSizeWithNoParameterConstructor() {
        BaseStack<Character> stack = new BaseStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push((char)i);
        }

        assertThrows(IllegalStateException.class, ()->stack.push('h'), "Attempted call to push() on full Stack");
    }

    @Test
    @DisplayName("throws error if size parameter is smaller then number of initial elements")
    void throwsErrorIfSizeParameterIsSmallerThenNumberOfInitialElements() {
        // equals should not throw error
        BaseStack<Integer> stack = new BaseStack<>(4, 5, 8, 6, 8);

        assertThrows(IllegalArgumentException.class, () -> {
            BaseStack<Character> stack1 = new BaseStack<>(2, 'a', 'b', 'c');
        }, "Size can not be smaller then the number of initial elements");

    }

    @Test
    @DisplayName("throws error for call on pop to empty stack")
    void throwsErrorForCallOnPopToEmptyStack() {
        BaseStack<Object> stack = new BaseStack<>();

        assertThrows(IllegalStateException.class, stack::pop, "Attempted call to pop() on empty stack");
    }

    @Test
    @DisplayName("stack size must be not negative")
    void stackSizeMustBeNotNegative() {
        //zero is a valid size
        BaseStack<Object> stack = new BaseStack<>(0);


        assertThrows(IllegalArgumentException.class, () -> new BaseStack<>(-3), "Stack size must be a non-negative Integer");
    }
}