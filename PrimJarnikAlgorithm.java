import java.util.*;

public class PrimJarnikAlgorithm {

    // Method to implement Prim's Algorithm
    public static Set<Edge> prim(Map<String, List<Edge>> graph, String start) {
        Set<Edge> mst = new HashSet<>(); // Minimum Spanning Tree
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Set<String> visited = new HashSet<>();

        // Start with the initial vertex
        visited.add(start);
        priorityQueue.addAll(graph.get(start)); // Add all edges from the start node

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll(); // Get the edge with the smallest weight

            if (visited.contains(edge.target)) {
                continue; // Ignore edges leading to visited nodes
            }

            // Add the edge to the MST
            mst.add(edge);
            visited.add(edge.target); // Mark the target node as visited

            // Add all edges from the newly visited node
            priorityQueue.addAll(graph.get(edge.target));
        }

        return mst;
    }

    // Helper class to represent an edge
    static class Edge {
        String target;
        int weight;

        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        Map<String, List<Edge>> graph = new HashMap<>();

        graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 4)));
        graph.put("B", Arrays.asList(new Edge("A", 1), new Edge("C", 2), new Edge("D", 5)));
        graph.put("C", Arrays.asList(new Edge("A", 4), new Edge("B", 2), new Edge("D", 1)));
        graph.put("D", Arrays.asList(new Edge("B", 5), new Edge("C", 1)));

        // Run Prim's algorithm
        String startNode = "A";
        Set<Edge> minimumSpanningTree = prim(graph, startNode);

        // Print the results
        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Edge: " + edge.target + " (Weight: " + edge.weight + ")");
        }
    }
}
