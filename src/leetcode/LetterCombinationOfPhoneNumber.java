package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> digitToLetters = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};

        List<String> waits = new ArrayList<>();
        waits.add("");

        for (int i = 0; i < digits.length(); i++) {
            List<Character> correspondenceLetter = digitToLetters.get(digits.charAt(i));
            List<String> nextWaits = new ArrayList<>();

            for (String wait : waits) {
                for (Character c : correspondenceLetter) {
                    nextWaits.add(wait + c);
                }
            }

            waits = nextWaits;
        }
        waits.remove("");

        return waits;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
