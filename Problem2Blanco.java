import java.util.*;

public class Problem2Blanco {
    public static Map<String, Integer> getEdgesFromAdjMatrixBlanco(int[][] matrixBlanco) {
        Map<String, Integer> edgeCountBlanco = new HashMap<>();
        int nBlanco = matrixBlanco.length;
        for (int iBlanco = 0; iBlanco < nBlanco; iBlanco++) {
            for (int jBlanco = iBlanco; jBlanco < nBlanco; jBlanco++) {
                if (matrixBlanco[iBlanco][jBlanco] > 0) {
                    String edgeBlanco = iBlanco + "-" + jBlanco;
                    edgeCountBlanco.put(edgeBlanco, matrixBlanco[iBlanco][jBlanco]);
                }
            }
        }
        return edgeCountBlanco;
    }

    public static void main(String[] args) {
        int[][] matrix1Blanco = {
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 1, 0}
        };
        
        int[][] matrix2Blanco = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };
        
        int[][] matrix3Blanco = {
            {0, 2, 0, 0},
            {2, 0, 3, 0},
            {0, 3, 0, 4},
            {0, 0, 4, 0}
        };
        
        int[][] matrix4Blanco = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        int[][] matrix5Blanco = {
            {0, 1},
            {1, 0}
        };
        
        System.out.println("Matrix 1: " + getEdgesFromAdjMatrixBlanco(matrix1Blanco));
        System.out.println("Matrix 2: " + getEdgesFromAdjMatrixBlanco(matrix2Blanco));
        System.out.println("Matrix 3: " + getEdgesFromAdjMatrixBlanco(matrix3Blanco));
        System.out.println("Matrix 4: " + getEdgesFromAdjMatrixBlanco(matrix4Blanco));
        System.out.println("Matrix 5: " + getEdgesFromAdjMatrixBlanco(matrix5Blanco));
    }
}
