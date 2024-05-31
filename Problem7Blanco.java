import java.util.*;

public class Problem7Blanco {
    public static int[][] constructIncMatrixBlanco(List<int[]> edgesBlanco, int nBlanco) {
        int[][] incMatrixBlanco = new int[nBlanco][edgesBlanco.size()];
        for (int jBlanco = 0; jBlanco < edgesBlanco.size(); jBlanco++) {
            int[] edgeBlanco = edgesBlanco.get(jBlanco);
            for (int iBlanco : edgeBlanco) {
                incMatrixBlanco[iBlanco][jBlanco]++;
            }
        }
        return incMatrixBlanco;
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

        List<List<int[]>> edgeListsBlanco = Arrays.asList(edges1Blanco, edges2Blanco, edges3Blanco, edges4Blanco, edges5Blanco);
        String[] messagesBlanco = {"edges1", "edges2", "edges3", "edges4", "edges5"};

        for (int iBlanco = 0; iBlanco < edgeListsBlanco.size(); iBlanco++) {
            System.out.println("\nIncidence Matrix for " + messagesBlanco[iBlanco] + ":");
            printMatrixBlanco(constructIncMatrixBlanco(edgeListsBlanco.get(iBlanco), iBlanco < 4 ? 4 : 3));
        }
    }
}
 
