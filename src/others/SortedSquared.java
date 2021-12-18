package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedSquared {
    int[] sortedSquaredArray(int[] array) {
        int[] fre = new int[10001];
        for (int a : array) {
            fre[Math.abs(a)]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < fre.length; i++)
            res.addAll(Collections.nCopies(fre[i], i * i));

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        SortedSquared sortedSquared = new SortedSquared();
        sortedSquared.sortedSquaredArray(new int[]{});
    }
}
