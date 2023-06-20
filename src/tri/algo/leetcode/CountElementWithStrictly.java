package tri.algo.leetcode;

import java.util.Arrays;

public class CountElementWithStrictly {

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        for (; i < nums.length && nums[i] == nums[0]; i++) ;

        int j = nums.length - 1;
        for (; j >= 0 && nums[j] == nums[nums.length - 1]; j--) ;

        return Math.max(j - i + 1, 0);
    }

    public static void main(String[] args) {
        CountElementWithStrictly solution = new CountElementWithStrictly();
        System.out.println(solution.countElements(new int[]{-2,3}));
    }
}
