import java.util.*;

public class DijkstraAlgorithm {

    // Method to implement Dijkstra's Algorithm
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        // Distance map to hold the shortest path from start to each node
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE); // Initialize distances to infinity
        }
        distances.put(start, 0); // Distance to the start node is 0

        // Priority queue to hold nodes to explore
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();

            // Explore neighbors
            for (Map.Entry<String, Integer> entry : graph.get(currentNode.name).entrySet()) {
                String neighbor = entry.getKey();
                int weight = entry.getValue();
                int newDistance = currentNode.distance + weight;

                // Only consider this new path if it's better
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    // Helper class to represent a node with its name and distance
    static class Node {
        String name;
        int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        graph.put("A", new HashMap<>(Map.of("B", 1, "C", 4)));
        graph.put("B", new HashMap<>(Map.of("A", 1, "C", 2, "D", 5)));
        graph.put("C", new HashMap<>(Map.of("A", 4, "B", 2, "D", 1)));
        graph.put("D", new HashMap<>(Map.of("B", 5, "C", 1)));

        // Run Dijkstra's algorithm
        String startNode = "A";
        Map<String, Integer> shortestPaths = dijkstra(graph, startNode);

        // Print the results
        System.out.println("Shortest paths from node " + startNode + ":");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("Distance to " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
