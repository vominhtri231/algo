package leetcode.sortedarray;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = (l + r) / 2;

            if (target == nums[m]) {
                return m;
            }

            if (target > nums[m]) {
                if (nums[m] >= nums[l]) {
                    // left portion
                    l = m + 1;
                } else {
                    // right portion
                    if (target > nums[r]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if (nums[m] <= nums[r]) {
                    // right portion
                    r = m - 1;
                } else {
                    if (target < nums[l]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
