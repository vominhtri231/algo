package leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] minimumPaths = new int[n][m];
        minimumPaths[0][0] = grid[0][0];

        for (int sum = 1; sum < n + m - 1; sum++) {
            for (int i = 0; i < n; i++) {
                int j = sum - i;

                if (j < 0 || j >= m) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                if (i != 0) {
                    min = Math.min(min, minimumPaths[i - 1][j]);
                }
                if (j != 0) {
                    min = Math.min(min, minimumPaths[i][j - 1]);
                }
                minimumPaths[i][j] = min + grid[i][j];
            }
        }

        return minimumPaths[n - 1][m - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
