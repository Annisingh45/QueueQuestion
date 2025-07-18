package com.bridgelabz.queue;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;


public class PrinterQueueSimulation {

    // Represents a print job with a name and priority
    static class PrintJob {
        private final String jobName;
        private final int priority; // Higher number = higher priority

        public PrintJob(String jobName, int priority) {
            this.jobName = jobName;
            this.priority = priority;
        }

        public String getJobName() {
            return jobName;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "PrintJob{name='" + jobName + "', priority=" + priority + "}";
        }
    }

    // Printer queue that processes jobs by priority (highest first)
    static class PrinterQueue {
        private final PriorityQueue<PrintJob> queue;

        public PrinterQueue() {
            // Higher priority jobs come first
            this.queue = new PriorityQueue<>(Comparator.comparingInt(PrintJob::getPriority).reversed());
        }

        public void addJob(PrintJob job) {
            queue.offer(job);
            System.out.println("Added: " + job);
        }

        public PrintJob processNextJob() {
            PrintJob job = queue.poll();
            if (job != null) {
                System.out.println("Processing: " + job);
            } else {
                System.out.println("No jobs to process.");
            }
            return job;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void printQueue() {
            System.out.println("Current Queue:");
            queue.stream()
                    .sorted(Comparator.comparingInt(PrintJob::getPriority).reversed())
                    .forEach(System.out::println);
        }
    }

    // Main simulation
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Printer Queue Simulation (type 'exit' to quit)");
        while (true) {
            System.out.println("\nOptions: 1) Add Job  2) Process Next Job  3) Show Queue  4) Exit");
            System.out.print("Choose option: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                System.out.print("Enter job name: ");
                String name = scanner.nextLine().trim();
                System.out.print("Enter job priority (integer, higher = more important): ");
                int priority;
                try {
                    priority = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid priority. Try again.");
                    continue;
                }
                printerQueue.addJob(new PrintJob(name, priority));
            } else if (input.equals("2")) {
                printerQueue.processNextJob();
            } else if (input.equals("3")) {
                printerQueue.printQueue();
            } else if (input.equals("4") || input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting simulation.");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}