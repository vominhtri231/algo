package courseraalgo.w5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] changes = new int[m + 1];
        changes[0] = 0;

        for (int i = 1; i <= m; i++) {
            int changeFrom1 = i - 1 >= 0 ? changes[i - 1] + 1 : Integer.MAX_VALUE;
            int changeFrom3 = i - 3 >= 0 ? changes[i - 3] + 1 : Integer.MAX_VALUE;
            int changeFrom4 = i - 4 >= 0 ? changes[i - 4] + 1 : Integer.MAX_VALUE;
            changes[i] = Collections.min(Arrays.asList(changeFrom1, changeFrom3, changeFrom4));
        }

        return changes[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

