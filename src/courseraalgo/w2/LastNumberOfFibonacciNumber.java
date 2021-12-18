package courseraalgo.w2;

import java.util.Scanner;

public class LastNumberOfFibonacciNumber {

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = (a + b) % 10;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
