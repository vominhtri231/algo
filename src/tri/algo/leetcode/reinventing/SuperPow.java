package tri.algo.leetcode.reinventing;

public class SuperPow {

    public int superPow(int a, int[] b) {
        int currentUnitPow = a % 1337;
        int pow = 1;

        for (int i = b.length - 1; i >= 0; i--) {
            int nextUnitPow = currentUnitPow;
            for (int j = 0; j < 9; j++) {
                nextUnitPow = (nextUnitPow * currentUnitPow) % 1337;

                if (j < b[i]) {
                    pow = (pow * currentUnitPow) % 1337;
                }
            }
            currentUnitPow = nextUnitPow;
        }

        return pow;
    }

    public static void main(String[] args) {
        SuperPow solution = new SuperPow();
        System.out.println(solution.superPow(1, new int[]{4,3,3,8,5,2}));
    }
}
