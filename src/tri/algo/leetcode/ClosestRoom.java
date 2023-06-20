package tri.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestRoom {
    static class Solution {
        public int[] closestRoom(int[][] rooms, int[][] queries) {
            Arrays.sort(rooms, Comparator.comparingInt(a -> a[0]));

            return Arrays.stream(queries).mapToInt(query -> {
                int prefer = query[0];
                int min = query[1];

                List<int[]> okRooms = Arrays.stream(rooms).filter(room -> room[1] >= min).collect(Collectors.toList());

                int low = 0;
                int high = okRooms.size() - 1;

                while (low < high) {
                    int mid = (low + high) >>> 1;
                    int cmp = okRooms.get(mid)[0] - prefer;

                    if (cmp < 0)
                        low = mid + 1;
                    else if (cmp > 0)
                        high = mid - 1;
                    else
                        return okRooms.get(mid)[0];
                }

                if (low < 0 || low >= okRooms.size()) {
                    return -1;
                }
                return okRooms.get(low)[0];
            }).toArray();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.closestRoom(
                new int[][]{{2, 2}, {1, 2}, {3, 2}},
                new int[][]{{3, 1}, {3, 3}, {5, 2}})));
    }
}
