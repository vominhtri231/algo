package tri.algo.coursera.algotoolbox.w2;

import java.util.Scanner;

public class GreatestCommonDivisor {
    private static int gcd_naive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd_naive(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}
