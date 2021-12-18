package courseraalgo.w3;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, LargestNumber::compareDigit);
        return String.join("", a);
    }

    private static int compareDigit(String a, String b) {
        String ab = a + b;
        String ba = b + a;
        return -ab.compareTo(ba);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

