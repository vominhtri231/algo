package tri.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumGoodPeople {

    public int maximumGood(int[][] statements) {
        int len = statements.length;
        List<Set<Integer>> possibles = new ArrayList<>();

        Set<Integer> init = new HashSet<>();
        for (int i = 0; i < len; i++) init.add(i);
        possibles.add(init);


        for (int j = 0; j < len; j++) {
            Set<Integer> good = new HashSet<>();
            Set<Integer> bad = new HashSet<>();

            for (int i = 0; i < len; i++) {
                if (statements[i][j] == 0) {
                    bad.add(i);
                } else {
                    good.add(i);
                }
            }

            List<Set<Integer>> nextPossibles = new ArrayList<>();
            for (Set<Integer> possible : possibles) {

                Set<Integer> g1 = possible.stream().filter(good::contains).collect(Collectors.toSet());
                Set<Integer> g2 = possible.stream().filter(bad::contains).collect(Collectors.toSet());

                if (!g1.isEmpty()) nextPossibles.add(g1);
                if (!g2.isEmpty()) nextPossibles.add(g2);
            }
            possibles = nextPossibles;
        }

        int max = 0;
        for (Set<Integer> possible : possibles) {
            max = Math.max(possible.size(), max);
        }

        return max;
    }


    public static void main(String[] args) {
        MaximumGoodPeople solution = new MaximumGoodPeople();
        System.out.println(solution.maximumGood(new int[][]{{2,1,2}, {1,2,2}, {2,0,2}}));
    }

}
