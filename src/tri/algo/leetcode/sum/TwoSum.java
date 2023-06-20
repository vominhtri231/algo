package tri.algo.leetcode.sum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> wantedValue = new HashMap<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if (wantedValue.containsKey(num)) {
                return new int[]{wantedValue.get(num), i};
            }

            wantedValue.put(target - num, i);
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }
}
