package leetcode;

import java.util.Arrays;

public class RearrageArrayElementBySign {

    public int[] rearrangeArray(int[] nums) {
        int[] p = new int[nums.length / 2];
        int pc = 0;
        int[] n = new int[nums.length / 2];
        int nc = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                n[nc++] = nums[i];
            } else {
                p[pc++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[i * 2] = p[i];
            nums[i * 2 + 1] = n[i];
        }

        return nums;
    }


    public static void main(String[] args) {
        RearrageArrayElementBySign solution = new RearrageArrayElementBySign();
        System.out.println(Arrays.toString(solution.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }
}
