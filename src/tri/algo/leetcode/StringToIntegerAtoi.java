package tri.algo.leetcode;

public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        String trimmedInput = s.replaceAll("^\\s+", "");
        if (trimmedInput.isEmpty()) {
            return 0;
        }

        char firstChar = trimmedInput.charAt(0);
        int sign = 1;
        if (firstChar == '+' || firstChar == '-') {
            trimmedInput = trimmedInput.substring(1);

            if (firstChar == '-') {
                sign = -1;
            }
        }

        long absRes = 0;
        for (int i = 0; i < trimmedInput.length(); i++) {
            char currentChar = trimmedInput.charAt(i);
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            absRes = absRes * 10 + currentChar - '0';

            if (absRes * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (absRes * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

        }

        return (int)absRes * sign;
    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("9223372036854775808"));

    }
}
