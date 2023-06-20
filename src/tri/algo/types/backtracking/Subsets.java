package tri.algo.types.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        return new SubsetsFinder(nums).findSubsets();
    }

    static class SubsetsFinder {
        private final int[] nums;
        private final List<List<Integer>> results = new ArrayList<>();

        SubsetsFinder(int[] nums) {
            this.nums = nums;
        }

        private List<List<Integer>> findSubsets() {
            findSubsets(new boolean[nums.length], 0);
            return results;
        }

        private void findSubsets(boolean[] subset, int position) {
            if (position == nums.length) {
                results.add(convertToListResult(subset));
                return;
            }


            findSubsets(subset, position + 1);

            subset[position] = true;
            findSubsets(subset, position + 1);
            subset[position] = false;
        }

        private List<Integer> convertToListResult(boolean[] subset) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < subset.length; i++) {
                if (subset[i]) {
                    result.add(nums[i]);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

}
