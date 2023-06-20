package tri.algo.coursera.algotoolbox.w6;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] ws) {
        int[][] maxWeightTable = new int[ws.length + 1][W + 1];

        for (int i = 1; i <= ws.length; i++) {
            for (int j = 1; j <= W; j++) {
                int notUseItem = maxWeightTable[i - 1][j];
                int useItem = j - ws[i - 1] >= 0 ? maxWeightTable[i - 1][j - ws[i - 1]] + ws[i - 1] : Integer.MIN_VALUE;
                maxWeightTable[i][j] = Math.max(notUseItem, useItem);
            }
        }

        return maxWeightTable[ws.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

