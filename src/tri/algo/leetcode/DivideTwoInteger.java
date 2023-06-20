package tri.algo.leetcode;

public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? 1 : dividend == 0 ? 0 : -1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        ValueQuotation[] references = new ValueQuotation[32];
        int i = 0;
        long value = longDivisor;
        long refer = 1;
        while (value <= longDividend) {
            references[i] = new ValueQuotation(value, refer);
            value = value + value;
            refer = refer + refer;
            i++;
        }

        long absQuotation = 0;
        for (i--; i >= 0; i--) {
            if (longDividend >= references[i].value) {
                absQuotation += references[i].quotation;
                longDividend -= references[i].value;
            }
        }

        long longQuotation = sign * absQuotation;

        if (longQuotation > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (longQuotation < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) longQuotation;
    }

    static class ValueQuotation {
        long value;
        long quotation;

        public ValueQuotation(long value, long quotation) {
            this.value = value;
            this.quotation = quotation;
        }
    }

    public static void main(String[] args) {
        DivideTwoInteger solution = new DivideTwoInteger();
        System.out.println(solution.divide(-2147483648, 1));
    }


}
