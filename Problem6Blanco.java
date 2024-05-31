import java.util.*;

public class Problem6Blanco {
    public static int[][] constructAdjMatrixBlanco(List<int[]> edgesBlanco, int nBlanco) {
        int[][] adjMatrixBlanco = new int[nBlanco][nBlanco];
        for (int[] edgeBlanco : edgesBlanco) {
            adjMatrixBlanco[edgeBlanco[0]][edgeBlanco[1]]++;
            adjMatrixBlanco[edgeBlanco[1]][edgeBlanco[0]]++;
        }
        return adjMatrixBlanco;
    }

    public static void printMatrixBlanco(int[][] matrixBlanco) {
        for (int[] rowBlanco : matrixBlanco) {
            System.out.println(Arrays.toString(rowBlanco));
        }
    }

    public static void main(String[] args) {
        List<int[]> edges1Blanco = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3});
        List<int[]> edges2Blanco = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        List<int[]> edges3Blanco = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});
        List<int[]> edges4Blanco = Arrays.asList(new int[]{0, 1}, new int[]{2, 3});
        List<int[]> edges5Blanco = Arrays.asList(new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2});

        System.out.println("Adjacency Matrix for edges1Blanco:");
        printMatrixBlanco(constructAdjMatrixBlanco(edges1Blanco, 4));

        System.out.println("\nAdjacency Matrix for edges2Blanco:");
        printMatrixBlanco(constructAdjMatrixBlanco(edges2Blanco, 3));

        System.out.println("\nAdjacency Matrix for edges3Blanco:");
        printMatrixBlanco(constructAdjMatrixBlanco(edges3Blanco, 4));

        System.out.println("\nAdjacency Matrix for edges4Blanco:");
        printMatrixBlanco(constructAdjMatrixBlanco(edges4Blanco, 4));

        System.out.println("\nAdjacency Matrix for edges5Blanco:");
        printMatrixBlanco(constructAdjMatrixBlanco(edges5Blanco, 3));
    }
}

