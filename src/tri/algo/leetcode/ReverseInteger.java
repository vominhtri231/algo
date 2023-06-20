package tri.algo.leetcode;

public class ReverseInteger {

    static class Solution {
        public int reverse(int x) {
            int sign = Integer.signum(x);
            x = x * sign;
            long absRes = 0;
            while (x > 0) {
                absRes = absRes * 10 + x % 10;

                if (absRes < Integer.MIN_VALUE || absRes > Integer.MAX_VALUE) {
                    return 0;
                }

                x /= 10;
            }

            return (int) absRes * sign;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}
