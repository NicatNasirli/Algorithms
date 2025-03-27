package algorithms.leetcode.topInterview150;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /*

   Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.
     */

    public static void main(String[] args) {
        MinStack minStackTest = new MinStack();
        minStackTest.push(2);
        minStackTest.push(0);
        minStackTest.push(3);
        minStackTest.push(0);
        System.out.println(minStackTest.minStack);
        System.out.println(minStackTest.stack);
        System.out.println(minStackTest.getMin());
        minStackTest.pop();
        System.out.println(minStackTest.getMin());
        minStackTest.pop();
        System.out.println(minStackTest.getMin());
        minStackTest.pop();
        System.out.println(minStackTest.getMin());
    }

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= this.minStack.peek()) {
            this.minStack.push(val);
        }
        this.stack.push(val);
    }

    public void pop() {
        int removed = 0;
        if (!this.stack.isEmpty()) removed = this.stack.pop();
        if (!minStack.isEmpty() && removed == this.minStack.peek()) this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return (!this.minStack.isEmpty()) ? this.minStack.peek() : 0;
    }
}
