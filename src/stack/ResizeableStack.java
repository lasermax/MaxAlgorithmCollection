package stack;

public class ResizeableStack<T> extends BaseStack<T> {

    public ResizeableStack() {
        super();
    }

    public ResizeableStack(int initialSize) {
        super(initialSize);
    }

    public ResizeableStack(T[] initialElements) {
        super(initialElements);
    }

    public ResizeableStack(int initialSize, T ...initialElements) {
        super(initialSize, initialElements);
    }

    public void resize(int newSize) {
        if (newSize < size()) {
            throw new IllegalArgumentException("Size can not be smaller then the number of elements on the stack");
        }
        Object[] newStack = new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, stackPointer);
        stack = newStack;
    }
}