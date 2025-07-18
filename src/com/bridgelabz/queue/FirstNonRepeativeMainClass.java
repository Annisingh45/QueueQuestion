package com.bridgelabz.queue;

public class FirstNonRepeativeMainClass {
    public static void main(String[] args) {
        FirstNonRepeativeCharacter finder = new FirstNonRepeativeCharacter();

        // Example 1
        String stream1 = "aabc";
        System.out.println("Stream: " + stream1);
        finder.printFirstNonRepeating(stream1); // Output: a a b b

        // Example 2
        String stream2 = "swiss";
        System.out.println("Stream: " + stream2);
        finder.printFirstNonRepeating(stream2); // Output: s s w w w

        // Example 3
        String stream3 = "teeter";
        System.out.println("Stream: " + stream3);
        finder.printFirstNonRepeating(stream3); // Output: t t e e e r
    }
}
