package leetcode.reinventing;

public class Sqrtx {
    public int mySqrt(int x) {
        long i = x;
        while (i * i > x) {
            i = (i + x / i) / 2;
        }

        return (int)i;
    }

    public static void main(String[] args) {
        Sqrtx solution = new Sqrtx();
        System.out.println(solution.mySqrt(2147395599));
    }
}
