package leetcode;

import java.util.Arrays;

public class FrequencyOfMostFrequency {

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int start = 0, end = 0;

        long sum = 0;
        while (end < nums.length) {
            sum += nums[end];

            while (sum + k < (long) nums[end] * (end - start + 1) && start < end) {
                sum -= nums[start];
                start++;
            }

            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
        System.out.println(maxFrequency(new int[]{1, 9, 10, 11, 19}, 3));
        System.out.println(maxFrequency(new int[]{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 4));
    }
}
