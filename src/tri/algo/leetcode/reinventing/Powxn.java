package tri.algo.leetcode.reinventing;

public class Powxn {

    public double myPow(double x, int n) {
        return myLongPow(x, n);
    }

    private double myLongPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return n % 2 == 0 ? myLongPow(x * x, n / 2) : x * myLongPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Powxn solution = new Powxn();
        System.out.println(solution.myPow(2.1, 3));
    }
}
