package tri.algo.coursera.algotoolbox.w3;

import java.util.Scanner;

public class MoneyChange {
    private static int getChange(int m) {
        int changeNumber = 0;
        if (m >= 10) {
            changeNumber += m / 10;
            m = m % 10;
        }
        if (m >= 5) {
            changeNumber += m / 5;
            m = m % 5;
        }
        changeNumber += m;
        return changeNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
