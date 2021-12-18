package others;

import java.util.HashMap;
import java.util.Map;

public class PerfectString {
    static String  perfectString(int n, int k) {
        Map<Character, char[]> base = new HashMap<>();
        base.put('x', new char[]{'y', 'z'});
        base.put('y', new char[]{'x', 'z'});
        base.put('z', new char[]{'x', 'y'});

        String res = "";
        k--;
        res += firstCharactor(n, k);
        if (res.length() == 0) {
            return res;
        }
        k = k % (1 << (n - 1));
        n--;
        while (n > 0) {
            char lastChar = res.charAt(res.length() - 1);
            int barier = 1 << (n - 1);
            if (k <= barier) {
                res += base.get(lastChar)[0];
            } else {
                res += base.get(lastChar)[1];
            }

            n--;
            k = k % barier;
        }
        return res;
    }

    static String firstCharactor(int n, int k) {
        int barier = 1 << (n - 1);
        if (k < barier) {
            return "x";
        }
        if (k < barier * 2) {
            return "y";
        }
        if (k < barier * 3) {
            return "z";
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(perfectString(3,9));
    }
}
