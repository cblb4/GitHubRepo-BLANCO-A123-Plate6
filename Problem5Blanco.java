import java.util.*;

public class Problem5Blanco {
    private Map<Integer, List<Integer>> adjListBlanco;
    private Map<Integer, Integer> colorsBlanco;

    public Problem5Blanco() {
        adjListBlanco = new HashMap<>();
        colorsBlanco = new HashMap<>();
    }

    public void addEdgeBlanco(int u, int v) {
        adjListBlanco.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjListBlanco.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    private boolean bfsCheckBlanco(int start) {
        Queue<Integer> queueBlanco = new LinkedList<>();
        queueBlanco.add(start);
        colorsBlanco.put(start, 0);

        while (!queueBlanco.isEmpty()) {
            int nodeBlanco = queueBlanco.poll();
            int currentColorBlanco = colorsBlanco.get(nodeBlanco);

            for (int neighborBlanco : adjListBlanco.getOrDefault(nodeBlanco, Collections.emptyList())) {
                if (!colorsBlanco.containsKey(neighborBlanco)) {
                    colorsBlanco.put(neighborBlanco, 1 - currentColorBlanco);
                    queueBlanco.add(neighborBlanco);
                } else if (colorsBlanco.get(neighborBlanco) == currentColorBlanco) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteBlanco() {
        for (int nodeBlanco : adjListBlanco.keySet()) {
            if (!colorsBlanco.containsKey(nodeBlanco)) {
                if (!bfsCheckBlanco(nodeBlanco)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem5Blanco graphBlanco = new Problem5Blanco();
        
        // Use Case 1: Bipartite Graph
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(2, 3);
        graphBlanco.addEdgeBlanco(3, 4);
        System.out.println("Case 1: Is Bipartite: " + graphBlanco.isBipartiteBlanco());

        // Use Case 2: Not Bipartite (Odd cycle)
        graphBlanco = new Problem5Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(2, 3);
        graphBlanco.addEdgeBlanco(3, 1);
        System.out.println("Case 2: Is Bipartite: " + graphBlanco.isBipartiteBlanco());

        // Use Case 3: Not Bipartite (Even cycle but same color on both sides)
        graphBlanco = new Problem5Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(2, 3);
        graphBlanco.addEdgeBlanco(3, 4);
        graphBlanco.addEdgeBlanco(4, 1);
        System.out.println("Case 3: Is Bipartite: " + graphBlanco.isBipartiteBlanco());

        // Use Case 4: Disconnected Bipartite Graph
        graphBlanco = new Problem5Blanco();
        graphBlanco.addEdgeBlanco(1, 2);
        graphBlanco.addEdgeBlanco(3, 4);
        System.out.println("Case 4: Is Bipartite: " + graphBlanco.isBipartiteBlanco());

        // Use Case 5: Single Node
        graphBlanco = new Problem5Blanco();
        graphBlanco.addEdgeBlanco(1, 1);
        System.out.println("Case 5: Is Bipartite: " + graphBlanco.isBipartiteBlanco());
    }
}