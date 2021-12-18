package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ThanosSort {
    public static void main(String[] args) {
        BrokenList brokenList = getBrokenListInput();
        while (!brokenList.isSorted()) {
            brokenList.broke();
        }
        System.out.println(brokenList.len);
    }

    private static BrokenList getBrokenListInput() {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        return new BrokenList(list);
    }

    static private class BrokenList {
        List<List<Integer>> brokenLists = new ArrayList<>();
        int len;

        BrokenList(List<Integer> initList) {
            brokenLists.add(initList);
            len = initList.size();
        }

        boolean isSorted() {
            return brokenLists
                    .stream()
                    .anyMatch(brokenList ->
                            IntStream.range(1, brokenList.size())
                                    .allMatch(i -> brokenList.get(i - 1) <= brokenList.get(i)));
        }

        void broke() {
            List<List<Integer>> copyBrokenLists = new ArrayList<>(brokenLists);
            brokenLists.clear();
            brokenLists.addAll(copyBrokenLists.stream()
                    .map(brokenList -> Arrays.asList(
                            brokenList.subList(0, brokenList.size() / 2),
                            brokenList.subList(brokenList.size() / 2, brokenList.size())))
                    .reduce(new ArrayList<>(), (lists, additionList) -> {
                        lists.addAll(additionList);
                        return lists;
                    }));
            len /= 2;
        }
    }
}
