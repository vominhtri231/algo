package tri.algo.leetcode;

import java.util.Arrays;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int startPoint = 0;
        while (startPoint <= matrix.length / 2) {

            int segmentLen = matrix.length - 2 * startPoint - 1;

            for (int i = 0; i < segmentLen; i++) {
                int saved = matrix[startPoint][startPoint + i];
                matrix[startPoint][startPoint + i]
                        = matrix[startPoint + segmentLen - i][startPoint];
                matrix[startPoint + segmentLen - i][startPoint]
                        = matrix[startPoint + segmentLen][startPoint + segmentLen - i];
                matrix[startPoint + segmentLen][startPoint + segmentLen - i] =
                        matrix[startPoint + i][startPoint + segmentLen];
                matrix[startPoint + i][startPoint + segmentLen] = saved;
            }
            startPoint++;
        }
    }

    public static void main(String[] args) {
        int[][] input33 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(input33);
        System.out.println(Arrays.deepToString(input33));

        int[][] input22 = new int[][]{{1, 2}, {3, 4}};
        rotate(input22);
        System.out.println(Arrays.deepToString(input22));

        int[][] input11 = new int[][]{{7}};
        rotate(input11);
        System.out.println(Arrays.deepToString(input11));
    }
}
