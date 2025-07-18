package com.bridgelabz.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
        private static class Node {
            int key;
            int value;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final LinkedList<Node> queue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.queue = new LinkedList<>();
        }


        public int get(int key) {
            Iterator<Node> it = queue.iterator();
            while (it.hasNext()) {
                Node node = it.next();
                if (node.key == key) {
                    it.remove();
                    queue.addLast(node); // Move to most recently used
                    return node.value;
                }
            }
            return -1;
        }


        public void put(int key, int value) {
            Iterator<Node> it = queue.iterator();
            while (it.hasNext()) {
                Node node = it.next();
                if (node.key == key) {
                    it.remove();
                    queue.addLast(new Node(key, value)); // Update and move to end
                    return;
                }
            }
            if (queue.size() >= capacity) {
                queue.removeFirst(); // Evict least recently used
            }
            queue.addLast(new Node(key, value));
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LRUCache{");
            for (Node node : queue) {
                sb.append(node.key).append("=").append(node.value).append(", ");
            }
            if (!queue.isEmpty()) {
                sb.setLength(sb.length() - 2); // Remove trailing comma
            }
            sb.append("}");
            return sb.toString();
        }
    }

