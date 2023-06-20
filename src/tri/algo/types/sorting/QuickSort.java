package tri.algo.types.sorting;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int l, int r) {
        if (l >= r) {
            return;
        }

        int j = partition(input, l, r);

        quickSort(input, l, j - 1);
        quickSort(input, j +     1, r);
    }

    private int partition(int[] input, int l, int r) {
        int pivot = l;
        int pivotValue = input[pivot];
        int i = l + 1;

        while (i <= r) {
            if (input[i] < pivotValue) {
                int nextGreaterThanPivot = input[pivot + 1];
                input[pivot] = input[i];
                input[i] = nextGreaterThanPivot;

                pivot++;
                input[pivot] = pivotValue;
            }
            i++;
        }

        return pivot;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] input = new int[]{12, 11, 13, 5, 6, 7};
        solution.quickSort(input);
        System.out.println(Arrays.toString(input));
    }
}
