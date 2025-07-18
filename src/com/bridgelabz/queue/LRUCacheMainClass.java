package com.bridgelabz.queue;

public class LRUCacheMainClass {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        System.out.println("Put (1, 10)");
        cache.put(1, 10);
        System.out.println(cache);

        System.out.println("Put (2, 20)");
        cache.put(2, 20);
        System.out.println(cache);

        System.out.println("Put (3, 30)");
        cache.put(3, 30);
        System.out.println(cache);

        System.out.println("Get (2): " + cache.get(2));
        System.out.println(cache);

        System.out.println("Put (4, 40)");
        cache.put(4, 40);
        System.out.println(cache);

        System.out.println("Get (1): " + cache.get(1));
        System.out.println("Get (3): " + cache.get(3));
        System.out.println(cache);

        System.out.println("Put (2, 25)");
        cache.put(2, 25);
        System.out.println(cache);
    }
}