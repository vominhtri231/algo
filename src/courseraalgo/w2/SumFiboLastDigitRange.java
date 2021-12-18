package courseraalgo.w2;

import java.util.Scanner;

public class SumFiboLastDigitRange {

    private static int[] period = new int[]{0, 1, 2, 4, 7, 2, 0, 3, 4, 8, 3, 2, 6, 9, 6, 6, 3, 0, 4, 5, 0, 6, 7, 4, 2, 7, 0, 8, 9, 8, 8, 7, 6, 4, 1, 6, 8, 5, 4, 0, 5, 6, 2, 9, 2, 2, 5, 8, 4, 3, 8, 2, 1, 4, 6, 1, 8, 0, 9, 0};

    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (from == 0) {
            return period[(int) (to % 60)];
        }

        int sumPartial = period[(int) (to % 60)] - period[(int) ((from - 1) % 60)];
        if (sumPartial < 0) {
            sumPartial = sumPartial + 10;
        }
        return sumPartial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}
