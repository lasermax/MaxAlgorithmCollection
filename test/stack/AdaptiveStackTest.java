package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdaptiveStackTest {

    @Test
    @DisplayName("Stack automatically resizes when full")
    void stackAutomaticallyResizesWhenFull() {
        AdaptiveStack<String> adaptiveStack = new AdaptiveStack<>(3);

        assertEquals(3, adaptiveStack.stack.length);
        adaptiveStack.push("Test1");
        adaptiveStack.push("Test2");
        adaptiveStack.push("Test3");
        adaptiveStack.push("Test4");
        assertEquals(8, adaptiveStack.stack.length);
        adaptiveStack.push("Test5");
        adaptiveStack.push("Test6");
        adaptiveStack.push("Test7");
        adaptiveStack.push("Test8");
        adaptiveStack.push("Test9");
        assertEquals(13, adaptiveStack.stack.length);

    }


    @Test
    @DisplayName("Getter and Setter for ResizeStepSize")
    void getterAndSetterForResizeStepSize() {
        AdaptiveStack<String> adaptiveStack = new AdaptiveStack<>(10, 15);
        assertEquals(15, adaptiveStack.getResizeStepSize());
        adaptiveStack.setResizeStepSize(3);
        assertEquals(3, adaptiveStack.getResizeStepSize());

    }

    @Test
    @DisplayName("Stack Constructor with initialSize resizeStepSize and initialElements")
    void stackConstructorWithInitialSizeResizeStepSizeAndInitialElements() {
        AdaptiveStack<Integer> adaptiveStack = new AdaptiveStack<>(5,8, 1, 4, 5, 7);

        assertEquals(5, adaptiveStack.stack.length);
        assertEquals(8, adaptiveStack.getResizeStepSize());
        assertEquals(4, adaptiveStack.size());

        assertEquals(7, adaptiveStack.pop());
        assertEquals(5, adaptiveStack.pop());
        assertEquals(4, adaptiveStack.pop());
        assertEquals(1, adaptiveStack.pop());

        assertThrows(IllegalArgumentException.class, () -> {
           new AdaptiveStack<Integer>(5, 10, 3, 8, 4, 2, 1, 0);
        });
    }

}