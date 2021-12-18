package courseraalgo.w5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

    static class Step {
        int value;
        int parent;

        Step(int value, int parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private static List<Integer> optimal_sequence(int n) {
        Step[] steps = new Step[n + 1];
        steps[1] = new Step(0, 0);

        for (int i = 2; i <= n; i++) {
            int stepAdd1 = steps[i - 1].value + 1;
            int stepMul2 = i % 2 == 0 ? steps[i / 2].value + 1 : Integer.MAX_VALUE;
            int stepMul3 = i % 3 == 0 ? steps[i / 3].value + 1 : Integer.MAX_VALUE;

            int stepMin = Collections.min(Arrays.asList(stepAdd1, stepMul2, stepMul3));
            int stepParent = stepMin == stepAdd1 ? i - 1 : stepMin == stepMul2 ? i / 2 : i / 3;
            steps[i] = new Step(stepMin, stepParent);
        }

        int working = n;
        List<Integer> seq = new ArrayList<>();
        while (working > 0) {
            seq.add(working);
            working = steps[working].parent;
        }
        Collections.reverse(seq);
        return seq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

