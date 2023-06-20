package tri.algo.coursera.algotoolbox.w6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        List<Long> denos = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c >= '0' && c <= '9') {
                int deno = c - '0';
                denos.add((long) deno);
            } else {
                ops.add(c);
            }
        }

        int n = denos.size();
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];
        for (int i = 0; i < n; i++) {
            min[i][i] = denos.get(i);
            max[i][i] = denos.get(i);
        }

        for (int diff = 1; diff <= n - 1; diff++) {
            for (int i = 0; i + diff < n; i++) {
                int j = i + diff;

                long minIj = Long.MAX_VALUE;
                long maxIj = Long.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    long minFirstTerm = min[i][k];
                    long maxFirstTerm = max[i][k];
                    long minSecondTerm = min[k + 1][j];
                    long maxSecondTerm = max[k + 1][j];
                    char op = ops.get(k);

                    long minMin = eval(minFirstTerm, minSecondTerm, op);
                    long minMax = eval(minFirstTerm, maxSecondTerm, op);
                    long maxMin = eval(maxFirstTerm, minSecondTerm, op);
                    long maxMax = eval(maxFirstTerm, maxSecondTerm, op);

                    List<Long> values = Arrays.asList(minMin, minMax, maxMin, maxMax);
                    minIj = Math.min(minIj, Collections.min(values));
                    maxIj = Math.max(maxIj, Collections.max(values));
                }

                min[i][j] = minIj;
                max[i][j] = maxIj;
            }
        }

        return max[0][n - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
