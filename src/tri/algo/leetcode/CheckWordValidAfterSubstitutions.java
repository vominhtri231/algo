package tri.algo.leetcode;

import java.util.Stack;

public class CheckWordValidAfterSubstitutions {

    public boolean isValid(String s) {
        Stack<Character> check = new Stack<>();
        char[] chars = s.toCharArray();

        for (char cur : chars) {
            if (cur != 'c') {
                check.push(cur);
                continue;
            }

            if (check.isEmpty() || check.pop() != 'b' || check.isEmpty() || check.pop() != 'a') {
                return false;
            }
        }

        return check.isEmpty();
    }

    public static void main(String[] args) {
        CheckWordValidAfterSubstitutions solution = new CheckWordValidAfterSubstitutions();
        System.out.println(solution.isValid("bc"));
    }
}
