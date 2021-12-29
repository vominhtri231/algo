package leetcode;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int k = nums.length - 1;

        while (true) {
            for (; i < nums.length && nums[i] == 0; i++) ;
            int j = i;
            for (; j < nums.length && nums[j] == 1; j++) ;
            for (; k >= 0 && nums[k] == 2; k--) ;

            if (k < j) {
                break;
            }

            if (nums[i] == 2) {
                swap(nums, i, k);
            } else if (nums[j] == 2) {
                swap(nums, j, k);
            } else {
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums1 = new int[]{0};
        solution.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
