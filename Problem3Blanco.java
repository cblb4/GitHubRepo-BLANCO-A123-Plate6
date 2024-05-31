import java.util.*;

public class Problem3Blanco {
    private Map<Integer, List<Integer>> adjListBlanco;
    private Set<Integer> visitedBlanco;

    public Problem3Blanco() {
        adjListBlanco = new HashMap<>();
        visitedBlanco = new HashSet<>();
    }

    public void addEdgeBlanco(int u, int v) {
        adjListBlanco.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjListBlanco.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private boolean DFSBlanco(int nodeBlanco, int parentBlanco) {
        visitedBlanco.add(nodeBlanco);
        for (int neighborBlanco : adjListBlanco.getOrDefault(nodeBlanco, Collections.emptyList())) {
            if (!visitedBlanco.contains(neighborBlanco)) {
                if (DFSBlanco(neighborBlanco, nodeBlanco)) {
                    return true;
                }
            } else if (neighborBlanco != parentBlanco) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleBlanco() {
        visitedBlanco.clear();
        for (int nodeBlanco : adjListBlanco.keySet()) {
            if (!visitedBlanco.contains(nodeBlanco)) {
                if (DFSBlanco(nodeBlanco, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem3Blanco graphBlanco = new Problem3Blanco();
        
        // Use Case 1: No Cycle
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(2, 3);
        graphBlanco.addEdgeBlanco(3, 4);
        System.out.println("Use Case 1: Has Cycle: " + graphBlanco.hasCycleBlanco());

        // Use Case 2: Cycle Present
        graphBlanco = new Problem3Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(2, 3);
        graphBlanco.addEdgeBlanco(3, 1);
        System.out.println("Use Case 2: Has Cycle: " + graphBlanco.hasCycleBlanco());

        // Use Case 3: Self-loop
        graphBlanco = new Problem3Blanco();
        graphBlanco.addEdgeBlanco(1, 1);
        System.out.println("Use Case 3: Has Cycle: " + graphBlanco.hasCycleBlanco());

        // Use Case 4: Disconnected Graph with Cycle
        graphBlanco = new Problem3Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(3, 4);
        graphBlanco.addEdgeBlanco(4, 5);
        graphBlanco.addEdgeBlanco(5, 3);
        System.out.println("Use Case 4: Has Cycle: " + graphBlanco.hasCycleBlanco());

        // Use Case 5: Disconnected Graph without Cycle
        graphBlanco = new Problem3Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(3, 4);
        System.out.println("Use Case 5: Has Cycle: " + graphBlanco.hasCycleBlanco());
    }
}