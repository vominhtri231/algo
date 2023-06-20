package tri.algo.types.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    void permute(int[] nums, int step, List<List<Integer>> result) {
        if (step == nums.length - 1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = step; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = nums[step];
            nums[step] = t;

            permute(nums, step + 1, result);

            int t1 = nums[i];
            nums[i] = nums[step];
            nums[step] = t1;
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Node first = new Node(Arrays.stream(nums).boxed().collect(Collectors.toSet()), new ArrayList<>());
        Stack<Node> waiting = new Stack<>();
        waiting.add(first);

        while (!waiting.isEmpty()) {
            Node working = waiting.pop();

            if (working.available.isEmpty()) {
                result.add(working.value);
                continue;
            }

            for (Integer next : working.available) {
                Set<Integer> copyAvailable = new HashSet<>(working.available);
                copyAvailable.remove(next);

                List<Integer> copyValue = new ArrayList<>(working.value);
                copyValue.add(next);

                waiting.push(new Node(copyAvailable, copyValue));
            }
        }

        return result;
    }

    class Node {
        Set<Integer> available;
        List<Integer> value;

        public Node(Set<Integer> available, List<Integer> value) {
            this.available = available;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
