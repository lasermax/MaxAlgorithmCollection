package stack;

public interface Stack<T> {

    T pop();

    void push(T element);

    int maxSize();

    int size();

    boolean isEmpty();

    boolean isFull();
}
