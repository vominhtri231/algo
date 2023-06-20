package tri.algo.leetcode;

public class DecodeWays {

    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] numDecodings = new int[len + 1];
        numDecodings[len] = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] > 48) {
                numDecodings[i] += numDecodings[i + 1];
            }

            if (i + 1 >= len) {
                continue;
            }

            int twoNumber = chars[i] * 10 + chars[i + 1];
            if (twoNumber >= 538 && twoNumber <= 554) {
                numDecodings[i] += numDecodings[i + 2];
            }
        }
        return numDecodings[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("06"));
    }
}
