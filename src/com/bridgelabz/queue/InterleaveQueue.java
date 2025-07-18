package com.bridgelabz.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public static void interleave(Queue<Integer> queue) {
        int n = queue.size();
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Queue size must be even");
        }

        Stack<Integer> stack = new Stack<>();
        int half = n / 2;

        // Step 1: Push first half into stack
        for (int i = 0; i < half; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Enqueue back the stack elements (reversed first half)
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move the first half (which was originally the second half) to the back
        for (int i = 0; i < half; i++) {
            queue.offer(queue.poll());
        }

        // Step 4: Push first half (originally reversed first half) into stack again
        for (int i = 0; i < half; i++) {
            stack.push(queue.poll());
        }

        // Step 5: Interleave the elements of stack and queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
            queue.offer(queue.poll());
        }
    }

    // Example usage
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            queue.offer(i);
        }
        System.out.println("Original queue: " + queue);
        interleave(queue);
        System.out.println("Interleaved queue: " + queue);
    }
}