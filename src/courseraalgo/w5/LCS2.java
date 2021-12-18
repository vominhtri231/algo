package courseraalgo.w5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int[][] lcs = new int[a.length + 1][b.length + 1];

        for (int j = 1; j <= b.length; j++) {
            for (int i = 1; i <= a.length; i++) {
                int lcsIns = lcs[i - 1][j];
                int lcsDel = lcs[i][j - 1];
                int lcsMatch = lcs[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 1 : 0);
                lcs[i][j] = Collections.max(Arrays.asList(lcsIns, lcsDel, lcsMatch));
            }
        }
        return lcs[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

