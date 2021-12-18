package others;

import java.util.Arrays;

public class MaxIncreaseSubArray {

    int[][] maxIncreaseSubArray1(int[] arr) {
        int[][] maxArrays = initMaxArrays2(arr.length);
        for (int i = 0; i < maxArrays.length - 1; i++) {
            for (int j = 0; j < maxArrays[i].length; j++) {
                // not using arr[i]
                maxArrays[i + 1][j] = Math.min(maxArrays[i][j], maxArrays[i + 1][j]);

                // using arr[i]
                if (arr[i] > maxArrays[i][j]) {
                    maxArrays[i + 1][j + 1] = Math.min(arr[i], maxArrays[i + 1][j + 1]);
                }
            }
        }
        return maxArrays;
    }

    int[][] initMaxArrays1(int length) {
        int[][] maxArrays = new int[length + 1][];
        for (int i = 0; i <= length; i++) {
            maxArrays[i] = new int[i + 1];
            Arrays.fill(maxArrays[i], Integer.MAX_VALUE);
        }
        maxArrays[0][0] = -1;
        return maxArrays;
    }

    int[] maxIncreaseSubArray2(int[] arr) {
        int[][] maxArrays = initMaxArrays2(arr.length);
        for (int i = 0; i < maxArrays.length - 1; i++) {
            for (int j = 0; j < maxArrays[i].length; j++) {
                maxArrays[i + 1][j] = Math.max(maxArrays[i][j], maxArrays[i + 1][j]);

                if (arr[arr.length - i - 1] < maxArrays[i][j]) {
                    maxArrays[i + 1][j + 1] = Math.max(arr[arr.length - i - 1], maxArrays[i + 1][j + 1]);
                }
            }
        }
        return traceBack(arr, maxArrays);
    }

    int[][] initMaxArrays2(int length) {
        int[][] maxArrays = new int[length + 1][];
        for (int i = 0; i <= length; i++) {
            maxArrays[i] = new int[i + 1];
            Arrays.fill(maxArrays[i], -1);
        }
        maxArrays[0][0] = Integer.MAX_VALUE;
        return maxArrays;
    }

    int[] traceBack(int[] arr, int[][] maxArrays) {
        int resultLen = getResultLen(maxArrays);
        int[] res = new int[resultLen];

        int arrPosition = 0;
        int resPosition = 0;
        while (resPosition < resultLen) {
            int chosenArrayIndex = maxArrays.length - 1 - arrPosition;
            res[resPosition] = maxArrays[chosenArrayIndex][resultLen - resPosition];

            while (arrPosition < arr.length && arr[arrPosition] != res[resPosition]) {
                arrPosition++;
            }
            resPosition++;
        }

        return res;
    }

    int getResultLen(int[][] maxArrays) {
        int[] lastArray = maxArrays[maxArrays.length - 1];
        int resultLen = lastArray.length - 1;
        while (resultLen >= 0 && lastArray[resultLen] < 0) {
            resultLen--;
        }
        return resultLen;
    }


    public static void main(String[] args) {
        MaxIncreaseSubArray maxIncreaseSubArray = new MaxIncreaseSubArray();
        System.out.println(Arrays.toString(maxIncreaseSubArray.maxIncreaseSubArray2(new int[]{1,2,100,2,30})));
    }
}
