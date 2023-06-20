package tri.algo.leetcode;

import java.util.Arrays;

public class LongestParentheses {

    private static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();

        int[] longestParen = new int[len];
        int max = 0;

        for (int i = 1; i < len; i++) {
            if (chars[i] == '(') {
                continue;
            }

            if (chars[i - 1] == '(') {
                longestParen[i] = i - 2 >= 0 ? longestParen[i - 2] + 2 : 2;
                max = Math.max(longestParen[i], max);
                continue;
            }

            if (i - 1 - longestParen[i - 1] >= 0 && chars[i - 1 - longestParen[i - 1]] == '(') {
                longestParen[i] = longestParen[i - 1] + 2 + (i - 2 - longestParen[i - 1] >= 0 ? longestParen[i - 2 - longestParen[i - 1]] : 0);
                max = Math.max(longestParen[i], max);
            }
        }

        System.out.println(Arrays.toString(longestParen));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses(")()((()))"));
        System.out.println(longestValidParentheses("(())"));
    }
}
