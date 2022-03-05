package stack;

public class AdaptiveStack<T> extends ResizeableStack<T> {

    private static final int STD_RESIZE_STEP_SIZE = 5;

    private int resizeStepSize = STD_RESIZE_STEP_SIZE;

    public AdaptiveStack() {
        super();
    }

    public AdaptiveStack(int initialSize) {
        super(initialSize);
    }

    public AdaptiveStack(int initialSize, int resizeStepSize) {
        super(initialSize);

        this.resizeStepSize = resizeStepSize;
    }

    public AdaptiveStack(T[] initialElements) {
        super(initialElements);
    }

    public AdaptiveStack(int initialSize, T[] initialElements) {
        super(initialSize, initialElements);
    }

    public AdaptiveStack(int initialSize, int resizeStepSize, T ...initialElements) {
        super(initialSize, initialElements);

        this.resizeStepSize = resizeStepSize;
    }

    @Override
    protected void addElementOnFullStack(T element) {
        resize(stackPointer + resizeStepSize);
        addElement(element);
    }

    public int getResizeStepSize() {
        return resizeStepSize;
    }

    public void setResizeStepSize(int resizeStepSize) {
        this.resizeStepSize = resizeStepSize;
    }
}
