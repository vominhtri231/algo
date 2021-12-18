package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Set<Character> characters = new HashSet<>();
            int j = i;
            for (; j < s.length() && !characters.contains(s.charAt(j)); j++) {
                characters.add(s.charAt(j));
            }

            if (j - i > max) {
                max = j - i;
            }
        }

        return max;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        Set<Character> characters = new HashSet<>();

        while (end < s.length()) {
            char handleChar = s.charAt(end);

            while (characters.contains(handleChar)) {
                characters.remove(s.charAt(start));
                start++;
            }

            characters.add(handleChar);

            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") + "/" + lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcadbcbb") + "/" + lengthOfLongestSubstring2("abcadbcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb") + "/" + lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew") + "/" + lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring("") + "/" + lengthOfLongestSubstring2(""));
    }
}
