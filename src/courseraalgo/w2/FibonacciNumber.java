package courseraalgo.w2;

import java.util.Scanner;

public class FibonacciNumber {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
