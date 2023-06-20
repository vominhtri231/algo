package tri.algo.leetcode;

public class DungeonGame {

    private static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] minHP = new int[m][n];
        minHP[m - 1][n - 1] = dungeon[m - 1][n - 1];

        int sum = m + n - 3;
        while (sum >= 0) {
            for (int i = Math.max(sum - n + 1, 0); i < m && sum - i >= 0; i++) {
                int j = sum - i;
                minHP[i][j] = Integer.MIN_VALUE;

                if (i + 1 < m) {
                    minHP[i][j] = Math.max(Math.min(minHP[i + 1][j] + dungeon[i][j], 0), minHP[i][j]);
                }

                if (j + 1 < n) {
                    minHP[i][j] = Math.max(Math.min(minHP[i][j + 1] + dungeon[i][j], 0), minHP[i][j]);
                }

                if (minHP[i][j] > dungeon[i][j]) {
                    minHP[i][j] = dungeon[i][j];
                }
            }
            sum--;
        }
        return -Math.min(minHP[0][0], 0) + 1;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(calculateMinimumHP(new int[][]{{4}}));
        System.out.println(calculateMinimumHP(new int[][]{{-3, 5}}));
    }
}
