package tri.algo.coursera.algotoolbox.w5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] lcs = new int[a.length + 1][b.length + 1][c.length + 1];


        for (int k = 1; k <= c.length; k++) {
            for (int j = 1; j <= b.length; j++) {
                for (int i = 1; i <= a.length; i++) {
                    int lcsSkipC = lcs[i][j][k - 1];
                    int lcsSkipB = lcs[i][j - 1][k];
                    int lcsSkipA = lcs[i - 1][j][k];
                    int lcsSkipAB = lcs[i - 1][j - 1][k];
                    int lcsSkipAC = lcs[i - 1][j][k - 1];
                    int lcsSkipBC = lcs[i][j - 1][k - 1];
                    boolean allMatch = a[i - 1] == b[j - 1] && a[i - 1] == c[k - 1];
                    int lcsNonSkip = lcs[i - 1][j - 1][k - 1] + (allMatch ? 1 : 0);
                    lcs[i][j][k] = Collections.max(Arrays.asList(lcsSkipA, lcsSkipB, lcsSkipC, lcsSkipAB, lcsSkipAC, lcsSkipBC, lcsNonSkip));
                }
            }
        }

        return lcs[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

