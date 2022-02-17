package stack;

public class StandardStack<T> implements Stack<T> {

    private static final int STD_INITIAL_SIZE = 10;

    protected Object[] stackArray;
    private int stackPointer;

    public StandardStack() {
        this(STD_INITIAL_SIZE);
    }

    public StandardStack(int size) {
        stackArray = new Object[size];
        stackPointer = 0;
    }

    @Override
    public T pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("Attempted call to pop() on empty Stack");
        }
        stackPointer--;
        return (T)stackArray[stackPointer];
    }

    @Override
    public void push(T element) {
        if (isFull()) {
            manageFullStack(element);
        } else {
            addElementToStack(element);
        }
    }
    protected void manageFullStack(T element) {
        throw new IllegalStateException("Attempted call to push( " + element.toString() + " ) on full Stack");
    }

    protected void addElementToStack(T element) {
        stackArray[stackPointer] = element;
        stackPointer++;
    }

    @Override
    public int maxSize() {
        return stackArray.length;
    }

    @Override
    public int size() {
        return stackPointer;
    }

    @Override
    public boolean isEmpty() {
        return stackPointer == 0;
    }

    @Override
    public boolean isFull() {
        return stackPointer == stackArray.length;
    }
}
