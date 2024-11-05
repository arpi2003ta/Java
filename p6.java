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

// Stack implementation with thread communication
class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;
    private boolean isPushTurn = true; // To alternate between push and pop

    // Constructor to initialize stack
    public Stack(int size) {
        stackArray = new int[size];
        capacity = size;
        top = -1;
    }

    // Method to add an element to the stack (push operation)
    public synchronized void push(int element) throws OverflowException, InterruptedException {
        while (!isPushTurn) {
            wait(); // Wait if it's not the turn to push
        }

        if (top == capacity - 1) {
            throw new OverflowException("Stack is full");
        }
        stackArray[++top] = element;
        System.out.println("Pushed " + element);
        isPushTurn = false; // Switch turn to pop
        notify(); // Notify the other thread (pop) to proceed
    }

    // Method to remove an element from the stack (pop operation)
    public synchronized int pop() throws UnderflowException, InterruptedException {
        while (isPushTurn) {
            wait(); // Wait if it's not the turn to pop
        }

        if (top == -1) {
            throw new UnderflowException("Stack is empty");
        }
        int poppedElement = stackArray[top--];
        System.out.println("Popped " + poppedElement);
        isPushTurn = true; // Switch turn to push
        notify(); // Notify the other thread (push) to proceed
        return poppedElement;
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

// Thread class for pushing elements to the stack
class PushThread extends Thread {
    private Stack stack;

    public PushThread(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        int[] elementsToPush = {5, -1, 10, 15, -5};
        try {
            for (int element : elementsToPush) {
                stack.push(element); // Push elements into the stack
                Thread.sleep(500); // Simulate some delay between operations
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// Thread class for popping elements from the stack
class PopThread extends Thread {
    private Stack stack;

    public PopThread(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { // Pop as many times as elements pushed
                stack.pop(); // Pop elements from the stack
                Thread.sleep(500); // Simulate some delay between operations
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main class to test push and pop with two threads
public class p6 {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Stack of size 5

        PushThread pushThread = new PushThread(stack); // Thread for pushing elements
        PopThread popThread = new PopThread(stack);    // Thread for popping elements

        pushThread.start(); // Start the push thread
        popThread.start();  // Start the pop thread
    }
}
