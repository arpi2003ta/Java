// Custom exception for Stack Overflow
class OverflowException extends Exception {
    public OverflowException(String message) {
        super(message);
    }
}

// Custom exception for Stack Underflow
class UnderflowException extends Exception {
    public UnderflowException(String message) {
        super(message);
    }
}

// Stack implementation
class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public Stack(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1;
    }

    // Method to add an element to the stack
    public void push(int element) throws OverflowException {
        if (top == capacity - 1) {
            throw new OverflowException("Stack is full");
        }
        stackArray[++top] = element;
        System.out.println("Pushed: " + element);
    }

    // Method to remove an element from the stack
    public int pop() throws UnderflowException {
        if (top == -1) {
            throw new UnderflowException("Stack is empty");
        }
        System.out.println("Popped: " + stackArray[top]);
        return stackArray[top--];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
}

// Main class to test the stack
public class Main2 {
    public static void main(String[] args) {
        Stack stack = new Stack(3);  // Stack of size 3

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            // This will cause an OverflowException
            stack.push(40);
        } catch (OverflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            stack.pop();
            stack.pop();
            stack.pop();
            // This will cause an UnderflowException
            stack.pop();
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
