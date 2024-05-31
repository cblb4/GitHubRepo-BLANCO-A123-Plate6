import java.util.*;

public class Problem8Blanco {
    public static boolean areIsomorphicBlanco(Map<Integer, List<Integer>> g1Blanco, Map<Integer, List<Integer>> g2Blanco) {
        if (g1Blanco.size() != g2Blanco.size()) return false;

        Set<List<Integer>> g1DegreeSetBlanco = new HashSet<>();
        for (List<Integer> neighborsBlanco : g1Blanco.values()) {
            g1DegreeSetBlanco.add(Collections.unmodifiableList(neighborsBlanco));
        }

        for (List<Integer> neighborsBlanco : g2Blanco.values()) {
            if (!g1DegreeSetBlanco.contains(Collections.unmodifiableList(neighborsBlanco))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Use Case 1: Isomorphic Graphs
        Map<Integer, List<Integer>> adjList1Blanco = new HashMap<>();
        Map<Integer, List<Integer>> adjList2Blanco = new HashMap<>();
        adjList1Blanco.put(0, Arrays.asList(1, 2));
        adjList1Blanco.put(1, Arrays.asList(0, 2));
        adjList1Blanco.put(2, Arrays.asList(0, 1));
        adjList2Blanco.put(0, Arrays.asList(1, 2));
        adjList2Blanco.put(1, Arrays.asList(0, 2));
        adjList2Blanco.put(2, Arrays.asList(0, 1));
        System.out.println("Are Isomorphic: " + areIsomorphicBlanco(adjList1Blanco, adjList2Blanco));

        // Use Case 2: Not Isomorphic
        adjList1Blanco.clear();      
        adjList2Blanco.clear();
        adjList1Blanco.put(0, Arrays.asList(1, 2));
        adjList1Blanco.put(1, Arrays.asList(0, 2));
        adjList2Blanco.put(0, Arrays.asList(1, 2));
        adjList2Blanco.put(1, Arrays.asList(0, 2));
        adjList2Blanco.put(2, Arrays.asList(1, 3));
        System.out.println("Are Isomorphic: " + areIsomorphicBlanco(adjList1Blanco, adjList2Blanco));

        // Use Case 3: Different number of vertices
        adjList1Blanco.clear();
        adjList2Blanco.clear();
        adjList1Blanco.put(0, Arrays.asList(1));
        adjList2Blanco.put(0, Arrays.asList(1, 2));
        adjList2Blanco.put(1, Arrays.asList(0));
        System.out.println("Are Isomorphic: " + areIsomorphicBlanco(adjList1Blanco, adjList2Blanco));

        // Use Case 4: Different edges but same degree sequence
        adjList1Blanco.clear();
        adjList2Blanco.clear();
        adjList1Blanco.put(0, Arrays.asList(1, 2));
        adjList1Blanco.put(1, Arrays.asList(0, 2));
        adjList1Blanco.put(2, Arrays.asList(0, 1));
        adjList2Blanco.put(0, Arrays.asList(1, 3));
        adjList2Blanco.put(1, Arrays.asList(0, 3));
        adjList2Blanco.put(3, Arrays.asList(0, 1));
        System.out.println("Are Isomorphic: " + areIsomorphicBlanco(adjList1Blanco, adjList2Blanco));

        // Use Case 5: Single Node Graphs
        adjList1Blanco.clear();
        adjList2Blanco.clear();
        adjList1Blanco.put(0, Arrays.asList(0));
        adjList2Blanco.put(0, Arrays.asList(0));
        System.out.println("Are Isomorphic: " + areIsomorphicBlanco(adjList1Blanco, adjList2Blanco));
    }
}

