// Carlos Blanco
/*
 * Problem 1: Write a Java program that receives a list of edges of a simple graph.
 * The program should determine whether it is connected and find the number of
 * connected components if it is not connected.
 */

 
import java.util.*;

public class Problem1Blanco {
    private Map<Integer, List<Integer>> graphBlanco = new HashMap<>();
    private Set<Integer> visitedNodesBlanco = new HashSet<>();

    public void addEdge(int node1, int node2) {
        graphBlanco.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        graphBlanco.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    public boolean isConnected() {
        if (graphBlanco.isEmpty()) return true;
        visitedNodesBlanco.clear(); // Clear visitedNodesBlanco before running depthFirstSearch
        depthFirstSearch(graphBlanco.keySet().iterator().next());
        return visitedNodesBlanco.size() == graphBlanco.size();
    }

    public int countConnectedComponents() {
        visitedNodesBlanco.clear();
        int countBlanco = 0;
        for (int node : graphBlanco.keySet()) {
            if (!visitedNodesBlanco.contains(node)) {
                depthFirstSearch(node);
                countBlanco++;
            }
        }
        return countBlanco;
    }

    private void depthFirstSearch(int startNode) {
        Stack<Integer> stackBlanco = new Stack<>();
        stackBlanco.push(startNode);
        visitedNodesBlanco.add(startNode);  // Mark the starting node as visited
        while (!stackBlanco.isEmpty()) {
            int currentNode = stackBlanco.pop();
            for (int neighbor : graphBlanco.getOrDefault(currentNode, Collections.emptyList())) {
                if (visitedNodesBlanco.add(neighbor)) {  // Mark the node as visited and push to stack if not already visited
                    stackBlanco.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scannerBlanco = new Scanner(System.in);
        Problem1Blanco problem1Blanco = new Problem1Blanco();

        System.out.print("Enter the number of vertices: ");
        int numVerticesBlanco = scannerBlanco.nextInt();
        
        System.out.print("Number of edges: ");
        int numEdgesBlanco = scannerBlanco.nextInt();
        
        System.out.println("Enter each edge in the format 'u v': "); 
        for (int i = 0; i < numEdgesBlanco; i++) {
            problem1Blanco.addEdge(scannerBlanco.nextInt(), scannerBlanco.nextInt());
        }

        if (problem1Blanco.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " 
            + problem1Blanco.countConnectedComponents());
        }

        scannerBlanco.close();
    }
}
