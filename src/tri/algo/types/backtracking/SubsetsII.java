package tri.algo.types.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> numFre = new HashMap<>();
        for (int num : nums) {
            int fre = numFre.getOrDefault(num, 0) + 1;
            numFre.put(num, fre);
        }
        int[][] numFreArray = new int[numFre.size()][];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numFre.entrySet()) {
            numFreArray[i] = new int[]{entry.getKey(), entry.getValue()};
            i++;
        }

        return new SubsetFinder(numFreArray).findSubsets();
    }

    static class SubsetFinder {
        private final List<List<Integer>> results = new ArrayList<>();
        private final int[][] numFre;

        SubsetFinder(int[][] numFre) {
            this.numFre = numFre;
        }

        public List<List<Integer>> findSubsets() {
            findSubset(new int[numFre.length], 0);
            return results;
        }

        private void findSubset(int[] subset, int position) {
            if (position == numFre.length) {
                results.add(convertToList(subset));
                return;
            }

            for (int i = 0; i <= numFre[position][1]; i++) {
                subset[position] = i;

                findSubset(subset, position + 1);

                subset[position] = 0;
            }
        }

        private List<Integer> convertToList(int[] subset) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < subset.length; i++) {
                for (int j = 0; j < subset[i]; j++) {
                    result.add(numFre[i][0]);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
