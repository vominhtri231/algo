package courseraalgo.w4;

import java.util.Scanner;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, left, ave);
        numberOfInversions += getNumberOfInversions(a, ave, right);
        numberOfInversions += merge(a, left, ave, right);

        return numberOfInversions;
    }

    private static long merge(int[] a, int left, int ave, int right) {
        int[] b = new int[right - left];
        int i = 0;
        int j = left;
        int k = ave;
        long count = 0;
        while (j < ave) {
            if (k >= right || a[k] >= a[j]) {
                b[i] = a[j];
                j++;
            } else {
                count = count + ave - j;
                b[i] = a[k];
                k++;
            }
            i++;
        }
        System.arraycopy(b, 0, a, left, i);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a, 0, a.length));
    }
}

