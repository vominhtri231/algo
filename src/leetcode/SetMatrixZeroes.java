package leetcode;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean clearFirstRow = false;
        boolean clearFirstCol = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) clearFirstRow = true;
                    if (j == 0) clearFirstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) for (int j = 1; j < m; j++) matrix[i][j] = 0;
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) for (int i = 1; i < n; i++) matrix[i][j] = 0;
        }

        if (clearFirstRow) for (int j = 1; j < m; j++) matrix[0][j] = 0;
        if (clearFirstCol) for (int i = 1; i < n; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
