package tri.algo.leetcode;

import java.util.Arrays;

public class MinimumCostToBuyCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int result = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int fromLast = cost.length - i;
            if (fromLast % 3 != 0) {
                result += cost[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumCostToBuyCandiesWithDiscount solution = new MinimumCostToBuyCandiesWithDiscount();
        System.out.println(solution.minimumCost(new int[]{6,5,7,9,2,2}));
    }
}
