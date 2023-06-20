package tri.algo.leetcode;

import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0;

        int xMin = 0, xMax = n - 1;
        int yMin = 0, yMax = n - 1;
        int x = 0, y = 0;
        int value = 0;

        while (xMin <= xMax && yMin <= yMax) {
            matrix[x][y] = ++value;

            int nextX = x + directions[dirIdx][0];
            int nextY = y + directions[dirIdx][1];
            if (nextX <= xMax && nextX >= xMin && nextY <= yMax && nextY >= yMin) {
                x = nextX;
                y = nextY;
                continue;
            }

            dirIdx++;
            dirIdx %= 4;
            x = x + directions[dirIdx][0];
            y = y + directions[dirIdx][1];

            if (dirIdx == 1) {
                xMin++;
            } else if (dirIdx == 2) {
                yMax--;
            } else if (dirIdx == 3) {
                xMax--;
            } else {
                yMin++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
    }
}
