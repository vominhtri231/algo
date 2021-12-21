package leetcode.sortedarray;

public class FindMinimumInRotatedStoredArray {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                // in right portion or non rotated case
                r = m;
            } else if (nums[m] == nums[r]) {
                r--;
            } else {
                l = m + 1;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedStoredArray solution = new FindMinimumInRotatedStoredArray();
        System.out.println(solution.findMin(new int[]{2, 2, 2, 0, 1, 2}));
    }
}
