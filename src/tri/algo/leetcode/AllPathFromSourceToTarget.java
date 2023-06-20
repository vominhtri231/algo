package tri.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        current.add(0);
        backtrack(graph, current, result);
        return result;
    }

    private void backtrack(int[][] graph, LinkedList<Integer> current, List<List<Integer>> result) {
        if (current.getLast() == graph.length - 1) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int relative : graph[current.getLast()]){
            current.add(relative);
            backtrack(graph, current, result);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new AllPathFromSourceToTarget().allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println(lists);
    }
}
