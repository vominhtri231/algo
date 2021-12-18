package others;

public class PalindromeSubArray {
    int longestSubsequencePalindrome(int[] a) {
        int len = a.length;
        int[][] palins = initPalins(len);

        for (int diff = 2; diff <= len; diff++) {
            for (int i = 0; i + diff <= len; i++) {
                int j = i + diff;

                int usingLastIndex = a[i] == a[j - 1] ? palins[i + 1][j - 1] + 2 : Integer.MIN_VALUE;
                int notUsingLastIndex = Math.max(palins[i][j - 1], palins[i + 1][j]);
                palins[i][j] = Math.max(usingLastIndex, notUsingLastIndex);
            }
        }
        return palins[0][len];
    }

    int[][] initPalins(int len) {
        int[][] palins = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            palins[i][i] = 0;
            palins[i][i + 1] = 1;
        }
        palins[len][len] = 1;
        return palins;
    }

    public static void main(String[] args) {
        PalindromeSubArray palindromeSubArray = new PalindromeSubArray();
        System.out.println(palindromeSubArray.longestSubsequencePalindrome(new int[]{1, 2, 3, 4, 5, 3, 2, 5, 1}));
    }
}
