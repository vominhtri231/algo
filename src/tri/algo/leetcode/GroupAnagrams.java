package tri.algo.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupToAlphabetize = new HashMap<>();
        for (String str : strs) {
            String alpha = alphabetize(str);
            groupToAlphabetize.putIfAbsent(alpha, new ArrayList<>());
            groupToAlphabetize.get(alpha).add(str);
        }

        return new ArrayList<>(groupToAlphabetize.values());
    }

    private String alphabetize(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
