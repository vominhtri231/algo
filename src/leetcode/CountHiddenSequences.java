package leetcode;

public class CountHiddenSequences {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, cur = 0;

        for (int diff : differences) {
            cur = cur + diff;

            min = Math.min(cur, min);
            max = Math.max(cur, max);
        }

        return (int) Math.max((upper - lower) - (max - min) + 1, 0);
    }

    public static void main(String[] args) {
        CountHiddenSequences solution = new CountHiddenSequences();
        System.out.println(solution.numberOfArrays(new int[]{1}, 6, 7));
    }
}
