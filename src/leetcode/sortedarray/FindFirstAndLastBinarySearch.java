package leetcode.sortedarray;

public class FindFirstAndLastBinarySearch {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;

            if (nums[middle] == target) {
                firstIndex = middle;
            }

            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return firstIndex;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;

            if (nums[middle] == target) {
                lastIndex = middle;
            }

            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        FindFirstAndLastBinarySearch solution = new FindFirstAndLastBinarySearch();
        System.out.println(solution.findLast(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
