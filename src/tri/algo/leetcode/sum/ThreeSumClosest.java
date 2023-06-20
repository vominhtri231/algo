package tri.algo.leetcode.sum;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 100_000;

        int i = 0;
        while (i < nums.length) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }

                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

            int lastI = i;
            while (i < nums.length && nums[i] == nums[lastI]) i++;
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1));
    }
}
