class Stack {
    private int maxSize; // maximum size of the stack
    private int[] stackArray; // array to hold the stack elements
    private int top; // index of the top element

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is empty initially
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (top < maxSize - 1) { // Check if the stack is full
            stackArray[++top] = value; // Increment top and add the value
            System.out.println("Pushed " + value + " to the stack.");
        } else {
            System.out.println("Stack is full! Cannot push " + value);
        }
    }

    // Pop method to remove and return the top element
    public int pop() {
        if (!isEmpty()) { // Check if the stack is not empty
            return stackArray[top--]; // Return the top element and decrement top
        } else {
            System.out.println("Stack is empty! Cannot pop.");
            return -1; // Indicating that the stack is empty
        }
    }

    // Peek method to get the top element without removing it
    public int peek() {
        if (!isEmpty()) {
            return stackArray[top]; // Return the top element
        } else {
            System.out.println("Stack is empty! Cannot peek.");
            return -1; // Indicating that the stack is empty
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if top is -1
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        // Demonstrate stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This push will fail as the stack is full

        System.out.println("Top element is: " + stack.peek()); // Should print 50

        System.out.println("Popped element: " + stack.pop()); // Should print 50
        System.out.println("Popped element: " + stack.pop()); // Should print 40

        System.out.println("Top element after popping: " + stack.peek()); // Should print 30

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop()); // Pop all elements
        }

        stack.pop(); // This pop will fail as the stack is empty
    }
}
