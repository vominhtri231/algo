package tri.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int xMin = 0, xMax = matrix.length - 1;
        int yMin = 0, yMax = matrix[0].length - 1;
        int x = 0;
        int y = 0;
        int dirInx = 0;

        while (xMin <= xMax && yMin <= yMax) {
            result.add(matrix[x][y]);

            int nextX = x + directions[dirInx][0];
            int nextY = y + directions[dirInx][1];
            if (nextX >= xMin && nextX <= xMax && nextY >= yMin && nextY <= yMax) {
                x = nextX;
                y = nextY;
                continue;
            }

            dirInx++;
            if (dirInx == 1) {
                xMin++;
            } else if (dirInx == 2) {
                yMax--;
            } else if (dirInx == 3) {
                xMax--;
            } else {
                yMin++;
                dirInx = 0;
            }
            x = x + directions[dirInx][0];
            y = y + directions[dirInx][1];
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
