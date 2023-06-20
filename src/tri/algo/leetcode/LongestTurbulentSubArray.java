package tri.algo.leetcode;

public class LongestTurbulentSubArray {

    static class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int result = 1;
            int start = 0;
            int end = 1;
            int trend = 0;
            for (; end < arr.length; end++) {
                int currentTrend = Integer.compare(arr[end], arr[end - 1]);
                if (currentTrend * trend > 0) {
                    start = end - 1;
                }
                if (currentTrend == 0) {
                    start = end;
                }


                trend = currentTrend;

                result = Math.max(result, end - start + 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTurbulenceSize(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1}));
    }
}
