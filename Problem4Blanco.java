import java.util.*;

public class Problem4Blanco {
    public static Map<Integer, Integer> getVertexDegreesBlanco(List<int[]> edgesBlanco) {
        Map<Integer, Integer> degreeMapBlanco = new HashMap<>();
        for (int[] edgeBlanco : edgesBlanco) {
            degreeMapBlanco.put(edgeBlanco[0], degreeMapBlanco.getOrDefault(edgeBlanco[0], 0) + 1);
            degreeMapBlanco.put(edgeBlanco[1], degreeMapBlanco.getOrDefault(edgeBlanco[1], 0) + 1);
        }
        return degreeMapBlanco;
    }

    public static void main(String[] args) {
        List<int[]> edges1Blanco = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4});
        List<int[]> edges2Blanco = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1});
        List<int[]> edges3Blanco = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 1});
        List<int[]> edges4Blanco = Arrays.asList(new int[]{1, 2}, new int[]{3, 4});
        List<int[]> edges5Blanco = Arrays.asList(new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3});

        System.out.println("\nDegrees of Vertices in edges1Blanco: " + getVertexDegreesBlanco(edges1Blanco));
        System.out.println("\nDegrees of Vertices in edges2Blanco: " + getVertexDegreesBlanco(edges2Blanco));
        System.out.println("\nDegrees of Vertices in edges3Blanco: " + getVertexDegreesBlanco(edges3Blanco));
        System.out.println("\nDegrees of Vertices in edges4Blanco: " + getVertexDegreesBlanco(edges4Blanco));
        System.out.println("\nDegrees of Vertices in edges5Blanco: " + getVertexDegreesBlanco(edges5Blanco));
    }
}
