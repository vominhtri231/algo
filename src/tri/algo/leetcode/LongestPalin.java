package tri.algo.leetcode;

public class LongestPalin {

    private static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];

        for (int i = 0; i < len - 1; i++) {
            isPalin[i][i] = isPalin[i + 1][i] = true;
        }
        isPalin[len - 1][len - 1] = true;

        int start = 0;
        int max = 1;
        for (int pad = 1; pad < len; pad++) {
            for (int j = 0; j + pad < len; j++) {
                isPalin[j][j + pad] = isPalin[j + 1][j + pad - 1] && chars[j] == chars[j + pad];

                if (isPalin[j][j + pad]) {
                    start = j;
                    max = pad + 1;
                }
            }
        }

        return s.substring(start, max + start);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }
}
