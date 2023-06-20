package tri.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzacConversion {

    static class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1){
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());

            int trend = -1;
            int currentRow = 0;
            for (char c : s.toCharArray()) {
                rows.get(currentRow).append(c);

                if (currentRow == numRows - 1 || currentRow == 0) {
                    trend *= -1;
                }
                currentRow += trend;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("012345", 1));
    }
}
