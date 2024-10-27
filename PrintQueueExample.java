import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueExample {
    public static void main(String[] args) {
        // Initialize the queue
        Queue<String> printQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Print Queue System (type 'exit' to quit):");

        // Loop to add and process print jobs
        while (true) {
            System.out.print("Enter print job (or type 'print' to process a job): ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break; // Exit the program
            } else if (command.equalsIgnoreCase("print")) {
                // Process a print job
                if (!printQueue.isEmpty()) {
                    String job = printQueue.poll(); // Retrieve and remove the first element in the queue
                    System.out.println("Printing: " + job);
                } else {
                    System.out.println("No jobs in the queue.");
                }
            } else {
                // Add job to the queue
                printQueue.offer(command); // Add the job to the end of the queue
                System.out.println("Added job: " + command);
            }

            // Display the current state of the queue
            System.out.println("Current queue: " + printQueue);
        }

        scanner.close();
        System.out.println("Program ended.");
    }
}
