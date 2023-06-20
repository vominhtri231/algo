package tri.algo.leetcode;

import java.util.Arrays;

public class MaxAfterDecreasingAndRearranging {

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 < arr[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 2, 10, 10, 1}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{5}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
