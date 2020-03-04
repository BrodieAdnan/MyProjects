package espressioneinfissa;

import java.util.*;

public class Stack<T> {

    protected ArrayList<T> stack;
    private int testa;

    public Stack() {
        stack = new ArrayList();
        testa = -1;
    }

    public void push(T elem) {
        stack.add(elem);
        testa++;
    }

    public T pop() {
        return stack.remove(testa--);
    }

    public T top() {
        return stack.get(testa);
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    Stack riordina(Stack numeri) {
        return numeri;
    }
}
