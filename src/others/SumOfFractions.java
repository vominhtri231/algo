package others;

import java.util.Scanner;

public class SumOfFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int input = scanner.nextInt();

            int u = input;
            for (; isNotPrime(u); u--) ;

            int v = input + 1;
            for (; isNotPrime(v); v++) ;

            System.out.println(new Fraction(1, 2).add(new Fraction(-1, u).simply().add(new Fraction(input - u + 1, u * v).simply()).simply()));
        }
    }

    private static boolean isNotPrime(int a) {
        int j = 2;
        for (; j * j <= a; j++) {
            if (a % j == 0) break;
        }
        return j * j <= a;
    }

    static class Fraction {
        final long a, b;

        Fraction(long a, long b) {
            this.a = a;
            this.b = b;
        }

        Fraction add(Fraction addFraction) {
            long commonB = hcf(this.b, addFraction.b);
            long resultA = this.a * (commonB / this.b) + addFraction.a * (commonB / addFraction.b);
            return new Fraction(resultA, commonB);
        }

        Fraction simply() {
            long commonSimply = scmNonRec(this.b, this.a);
            return new Fraction(this.a / commonSimply, this.b / commonSimply);
        }

        @Override
        public String toString() {
            return a + "/" + b;
        }
    }

    private static long scm(long a, long b) {
        if (a > b) return scm(b, a);
        if (a == 0) return b;
        return scm(b % a, a);
    }

    private static long scmNonRec(long a, long b) {
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }
        while (a != 0) {
            long t = a;
            a = b % a;
            b = t;
        }
        return b;
    }

    private static long hcf(long a, long b) {
        return a * b / scmNonRec(a, b);
    }
}
