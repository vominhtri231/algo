package others;

public class PaintingFence {

    public static void main(String[] args) {
        System.out.println(solve(10, 20));
    }

    private static long solve(int n, int k) {
        long ans = 0;
        long ele = k;
        for (int i = 0; i < n - 1; i++) {
            ele *= k - 1;
            ele %= 1000000007L;
        }
        for (long l = 0; l <= n / 2; l++) {
            if (l > 0) {
                ele = ele * (n - 2 * l + 2) * (n - 2 * l + 1) / l / (n - l + 1) / (k - 1);
                ele %= 1000000007L;
            }
            ans += ele;
            ans %= 1000000007L;
        }

        return ans;
    }
}
