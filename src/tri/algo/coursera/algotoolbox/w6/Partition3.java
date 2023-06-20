package tri.algo.coursera.algotoolbox.w6;

import java.util.Arrays;
import java.util.Scanner;

public class Partition3 {
    private static int partition3(int[] gifts) {
        int totalGift = Arrays.stream(gifts).sum();
        if (totalGift % 3 != 0) {
            return 0;
        }
        int target = totalGift / 3;

        boolean[][] sumGifts = new boolean[target + 1][target + 1];
        sumGifts[0][0] = true;
        for (int gift : gifts) {
            boolean[][] nextSumGifts = new boolean[target + 1][target + 1];

            for (int i = 0; i < sumGifts.length; i++)
                for (int j = 0; j < sumGifts[i].length; j++)
                    if (sumGifts[i][j]) {
                        nextSumGifts[i][j] = true;
                        if (i + gift <= target) {
                            nextSumGifts[i + gift][j] = true;
                        }
                        if (j + gift <= target) {
                            nextSumGifts[i][j + target] = true;
                        }
                    }

            sumGifts = nextSumGifts;
        }

        return sumGifts[target][target] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

