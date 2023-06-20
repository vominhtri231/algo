package tri.algo.coursera.algotoolbox.w2;

import java.util.Scanner;

public class FibonacciNumberModulo {
    private static long getFibonacciHugeNaive(long n, long m) {
        long period = getPeriod(m);
        long ithPosition = n % period;

        if (ithPosition <= 1)
            return ithPosition;
        long a = 0, b = 1;

        for (int i = 2; i <= ithPosition; i++) {
            long temp = b;
            b = (a + b) % m;
            a = temp;
        }
        return b;
    }

    private static long getPeriod(long m) {
        long period = 0;
        long a = 0, b = 1;
        while (period == 0 || a != 0 || b != 1) {
            period++;
            long temp = b;
            b = (a + b) % m;
            a = temp;
        }
        return period;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
