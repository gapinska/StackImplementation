package stack;

public class Stack {
    private String[] stack;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    private boolean error;

    void initStack() {
        stack = new String[INITIAL_CAPACITY];
        size = 0;
        error = false;
    }

    public Stack() {
        initStack();
    }

    public void push(String item) {
        if (item instanceof String) {
            ensureCapacity();
            stack[size++] = (String) item;
        } else {
            error = true;
            System.err.println("Only strings are allowed in the stack.");
        }
    }

    public String pop() {
        if (isEmpty()) {
            error = true;
            System.err.println("Error: Attempted to pop from an empty stack.");
            return null;
        } else {
            String value = stack[--size];
            stack[size] = null;
            return value;
        }
    }

    public String peek() {
        if (isEmpty()) {
            setError(true);
            System.err.println("Error: Attempted to peek from an empty stack.");
            return null;
        } else {
            int index = size - 1;
            return stack[index];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void ensureCapacity() {
        if (size == stack.length) {
            int newCapacity = stack.length * 2;
            String[] newStack = new String[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
    }

    public String[] getStack() {
        return stack;
    }

    public int getSize() {
        return size;
    }

    public void resetStack() {
        initStack();
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
