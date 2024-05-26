package uy.edu.um.tads.stack;

public interface MyStack<T> {

    void push(T value);

    T pop() throws EmptyStackException;

    T peek();

    int size();

    boolean isEmpty();
}
