package courseraalgo.w5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class EditDistance {
    public static int EditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] editDistanceMap = new int[sLength + 1][tLength + 1];

        for (int i = 0; i <= tLength; i++) {
            editDistanceMap[0][i] = i;
        }

        for (int i = 0; i <= sLength; i++) {
            editDistanceMap[i][0] = i;
        }

        for (int j = 1; j <= tLength; j++) {
            for (int i = 1; i <= sLength; i++) {
                int eDIns = editDistanceMap[i][j - 1] + 1;
                int eDDel = editDistanceMap[i - 1][j] + 1;
                int match = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;
                int eDMatch = editDistanceMap[i - 1][j - 1] + match;
                editDistanceMap[i][j] = Collections.min(Arrays.asList(eDIns, eDDel, eDMatch));
            }
        }
        return editDistanceMap[sLength][tLength];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
