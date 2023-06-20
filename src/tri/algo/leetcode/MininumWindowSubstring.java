package tri.algo.leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MininumWindowSubstring {

    public static String minWindow(String s, String t) {
        String result = "";
        int start = 0, end = 0;
        WindowState windowState = new WindowState(t);

        while (end < s.length()) {
            windowState.addToWindow(s.charAt(end));

            while (windowState.validState()) {
                if (result.isEmpty() || result.length() > end - start + 1) {
                    result = s.substring(start, end + 1);
                }

                windowState.removeFromWindow(s.charAt(start));
                start++;
            }
            end++;
        }

        return result;
    }

    static class WindowState {
        Map<Character, Long> wanted;
        int count;

        WindowState(String input) {
            wanted = input.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            count = 0;
        }

        void addToWindow(char c) {
            if (!wanted.containsKey(c)) {
                return;
            }
            wanted.compute(c, (key, value) -> value == null ? null : value - 1);
            if (wanted.get(c) == 0) {
                count++;
            }
        }

        void removeFromWindow(char c) {
            if (!wanted.containsKey(c)) {
                return;
            }
            wanted.compute(c, (key, value) -> value == null ? 1 : value + 1);
            if (wanted.get(c) == 1) {
                count--;
            }
        }

        boolean validState() {
            return wanted.size() == count;
        }
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
