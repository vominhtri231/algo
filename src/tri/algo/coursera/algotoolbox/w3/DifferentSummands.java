package tri.algo.coursera.algotoolbox.w3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();

        for (int i = 1; n >= i; i++) {
            summands.add(i);
            n = n - i;
        }
        summands.set(summands.size() - 1, summands.get(summands.size() - 1) + n);
        //write your code here
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

