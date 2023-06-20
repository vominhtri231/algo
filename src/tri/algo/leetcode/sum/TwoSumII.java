package tri.algo.leetcode.sum;

import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
