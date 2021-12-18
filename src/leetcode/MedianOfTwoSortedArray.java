package leetcode;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeSortedArrays(nums1, nums2);

        if (mergedArray.length % 2 == 0) {
            int med = mergedArray.length / 2;
            return (mergedArray[med] + mergedArray[med - 1]) / 2.0;
        }

        return mergedArray[mergedArray.length / 2];
    }

    private int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int max = nums1.length + nums2.length;

        int k = 0;
        int[] result = new int[max];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
