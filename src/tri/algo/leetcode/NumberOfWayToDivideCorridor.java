package tri.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWayToDivideCorridor {

    public int numberOfWays(String corridor) {
        List<Long> plantDivs = new ArrayList<>();
        char[] positions = corridor.toCharArray();

        int count = 0;
        long plantCount = 0;
        for (char position : positions) {
            if (position == 'S') {
                count++;
                if (count > 1 && count % 2 == 1) {
                    plantDivs.add(plantCount);
                    plantCount = 0;
                }

            } else {
                if (count > 0 && count % 2 == 0) {
                    plantCount++;
                }
            }
        }

        if (count == 0 || count % 2 != 0) {
            return 0;
        }

        long result = 1;
        for (long plantDiv : plantDivs) {
            result = (result * (plantDiv + 1)) % 1_000_000_007;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        NumberOfWayToDivideCorridor solution = new NumberOfWayToDivideCorridor();
        System.out.println(solution.numberOfWays("SSPPSPS"));
        System.out.println(solution.numberOfWays("S"));
    }
}
