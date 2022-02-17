package stack;

public class AutoResizeableStack<T> extends ResizeableStack<T> {

    private static final int AUTO_RESIZE_STEP_SIZE = 5;

    public AutoResizeableStack() {
        super();
    }

    public AutoResizeableStack(int initialSize) {
        super(initialSize);
    }

    @Override
    protected void manageFullStack(T element) {
        this.resize(this.size() + AUTO_RESIZE_STEP_SIZE);
        this.addElementToStack(element);
    }
}
