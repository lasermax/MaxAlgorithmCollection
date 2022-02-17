package stack;

public class ResizeableStack<T> extends StandardStack<T>{

    public ResizeableStack() {
        super();
    }

    public ResizeableStack(int initialSize) {
        super(initialSize);
    }

    public void resize(int newSize) {
        if (this.size() > newSize) {
            throw new IllegalArgumentException("Can't resize a stack of size " + this.size() + " to new size of " + newSize);
        }
        Object[] newStackArray = new Object[newSize];

        System.arraycopy(stackArray, 0, newStackArray, 0, this.size());
        stackArray = newStackArray;
    }

}
