package stack;

public class BaseStack<T> implements Stack<T> {

    private static final int STD_SIZE = 10;

    protected int stackPointer = 0;
    protected Object[] stack;

    public BaseStack() {
        this(STD_SIZE);
    }

    public BaseStack(int size) {
        this.stack = new Object[size];
    }

    public BaseStack(T[] initialElements) {
        this(Math.max(initialElements.length, STD_SIZE), initialElements);
    }

    public BaseStack(int size, T... initialElements) {
        if (size < initialElements.length) {
            throw new IllegalArgumentException("Size can not be smaller then the number of initial elements");
        }
        this.stack = new Object[size];
        System.arraycopy(initialElements, 0, this.stack, 0, initialElements.length);
        stackPointer = initialElements.length;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Attempted call to pop() on empty Stack");
        }
        return (T) stack[--stackPointer];
    }

    public void push(T element) {
        if (isFull()) {
            addElementOnFullStack(element);
        } else {
            addElement(element);
        }
    }

    protected void addElementOnFullStack(T element) {
        throw new IllegalStateException("Attempted call to push() on full Stack");
    }

    protected void addElement(T element) {
        stack[stackPointer++] = element;
    }

    public int size() {
        return stackPointer;
    }

    public boolean isEmpty() {
        return stackPointer == 0;
    }

    private boolean isFull() {
        return stackPointer == stack.length;
    }


}
