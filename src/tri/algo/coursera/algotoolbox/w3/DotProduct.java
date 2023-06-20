package tri.algo.coursera.algotoolbox.w3;

import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + ((long) a[i]) * b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

