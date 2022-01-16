package leetcode.backtracking;

import java.util.*;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[][] numFre = toNumFre(nums);
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(numFre, new ArrayList<>(), result);
        return result;
    }

    private int[][] toNumFre(int[] nums) {
        Map<Integer, Integer> numFre = new HashMap<>();
        for (int num : nums) {
            int fre = numFre.getOrDefault(num, 0);
            numFre.put(num, fre + 1);
        }
        int i = 0;
        int[][] numFreArray = new int[numFre.size()][];
        for (Map.Entry<Integer, Integer> entry : numFre.entrySet()) {
            numFreArray[i++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return numFreArray;
    }

    void permuteUnique(int[][] allNumFre, List<Integer> permute, List<List<Integer>> result) {
        if (Arrays.stream(allNumFre).allMatch(numFre -> numFre[1] == 0)) {
            result.add(new ArrayList<>(permute));
            return;
        }

        for (int[] numfre : allNumFre) {
            if (numfre[1] > 0) {
                numfre[1] = numfre[1] - 1;
                permute.add(numfre[0]);

                permuteUnique(allNumFre, permute, result);

                permute.remove(permute.size() - 1);
                numfre[1] = numfre[1] + 1;
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
    }
}
