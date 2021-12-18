package courseraalgo.w3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    static class Item implements Comparable<Item> {
        int value;
        int weight;
        double valuePerWeight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            valuePerWeight = (double) value / weight;
        }

        @Override
        public int compareTo(Item o) {
            return valuePerWeight - o.valuePerWeight > 0 ? 1 : valuePerWeight == o.valuePerWeight ? 0 : -1;
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int length = values.length;
        Item[] items = new Item[length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        Arrays.sort(items);

        double value = 0;
        for (int i = length - 1; i >= 0 && capacity > 0; i--) {
            int weightToGet = Math.min(capacity, items[i].weight);
            value += items[i].valuePerWeight * weightToGet;
            capacity = capacity - weightToGet;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
