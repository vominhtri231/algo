package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DivideArrayEqually {

    boolean divideTheArrayEqually(int[] arr) {
        int totalSum = Arrays.stream(arr).reduce(0, Integer::sum);
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;

        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int ele : arr) {
            Set<Integer> nextLevelSums = new HashSet<>();
            sums.forEach(sum -> {
                nextLevelSums.add(sum);
                if (sum + ele <= target) {
                    nextLevelSums.add(sum + ele);
                }
            });
            sums = nextLevelSums;
        }

        return sums.contains(target);
    }

    public static void main(String[] args) {
        DivideArrayEqually divideArrayEqually = new DivideArrayEqually();
        System.out.println(divideArrayEqually.divideTheArrayEqually(new int[]{1, 5, 6}));
    }
}
