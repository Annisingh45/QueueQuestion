package com.bridgelabz.queue;

import java.util.LinkedList;
import java.util.Queue;


public class FirstNonRepeativeCharacter {
    public void printFirstNonRepeating(String stream) {
        int[] freq = new int[256];
        Queue<Character> queue = new LinkedList<>();
        System.out.print("First non-repeating characters in the stream: ");
        for (char ch : stream.toCharArray()) {
            freq[ch]++;
            queue.offer(ch);
            // Remove characters from the front of the queue until the front is non-repeating
            while (!queue.isEmpty() && freq[queue.peek()] > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        FirstNonRepeativeCharacter finder = new FirstNonRepeativeCharacter();
        String stream = "aabc";
        finder.printFirstNonRepeating(stream); // Output: a a b b
    }
}