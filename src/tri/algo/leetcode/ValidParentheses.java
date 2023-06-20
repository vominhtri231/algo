package tri.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> enclosed = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char cur : chars) {
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
                continue;
            }

            if (stack.isEmpty() || enclosed.get(stack.pop()) != cur) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()"));
    }
}
