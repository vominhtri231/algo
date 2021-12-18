package leetcode;

public class SumDigitsBaseK {

    public static int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBase(123, 10));
        System.out.println(sumBase(34, 6));
    }
}
