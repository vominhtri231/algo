package leetcode;

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] uniquePaths = new int[n][m];
        uniquePaths[n - 1][m - 1] = 1;

        for (int sum = n + m - 3; sum >= 0; sum--) {
            for (int i = 0; i < n; i++) {
                int j = sum - i;
                if (j >= 0 && j < m && obstacleGrid[i][j] != 1) {
                    uniquePaths[i][j] = (i + 1 < n ? uniquePaths[i + 1][j] : 0)
                            + (j + 1 < m ? uniquePaths[i][j + 1] : 0);
                }
            }
        }

        return uniquePaths[0][0];
    }

    public static void main(String[] args) {
        UniquePathII solution = new UniquePathII();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));
    }
}
