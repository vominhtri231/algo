package tri.algo.leetcode.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int wantedTwoSum = -nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] == wantedTwoSum) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    int lastL = l;
                    while (l < r && nums[lastL] == nums[l]) l++;
                    int lastR = r;
                    while (l < r && nums[lastR] == nums[r]) r--;

                    continue;
                }

                if (nums[l] + nums[r] < wantedTwoSum) {
                    l++;
                } else {
                    r--;
                }
            }

            int last = i;
            while (i < nums.length && nums[i] == nums[last]) i++;
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
