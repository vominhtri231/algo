package tri.algo.leetcode;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int minH = getMinHeight(heights, l, r);
        int result = 0;
        while (l < r) {
            result = Math.max(result, minH * (r - l + 1));
            if (heights[l] < heights[r]) {
                if (l == minH) {
                    minH = getMinHeight(heights, l, r);
                }

                l++;
            } else {
                if (r == minH) {
                    minH = getMinHeight(heights, l, r);
                }

                r--;
            }
        }

        return result;
    }

    private int getMinHeight(int[] heights, int r, int l) {
        int result = Integer.MAX_VALUE;

        for (int i = r; i <= l; i++) {
            if (heights[i] < result) {
                result = heights[i];
            }
        }

        return result;
    }
}
