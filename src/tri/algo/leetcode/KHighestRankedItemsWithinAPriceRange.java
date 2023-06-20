package tri.algo.leetcode;

import java.util.*;

public class KHighestRankedItemsWithinAPriceRange {

    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Point> waiting = new LinkedList<>();
        Set<Point> over = new HashSet<>();
        Point startingPoint = new Point(start[0], start[1]);
        waiting.add(startingPoint);
        over.add(startingPoint);

        int startValue = grid[start[0]][start[1]];
        if (startValue >= pricing[0] && startValue <= pricing[1]) {
            result.add(Arrays.asList(start[0], start[1]));
            if (k == 1) {
                return result;
            }
        }

        while (!waiting.isEmpty()) {
            Queue<Point> nextWaiting = new LinkedList<>();
            List<PointValue> valid = new ArrayList<>();

            for (Point p : waiting) {
                for (int[] dir : dirs) {
                    int nextX = p.x + dir[0];
                    int nextY = p.y + dir[1];

                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        continue;
                    }

                    int value = grid[nextX][nextY];
                    if (value == 0) {
                        continue;
                    }

                    Point nextPoint = new Point(nextX, nextY);
                    if (over.contains(nextPoint)) {
                        continue;
                    }

                    over.add(nextPoint);
                    nextWaiting.add(nextPoint);

                    if (value >= pricing[0] && value <= pricing[1]) {
                        valid.add(new PointValue(nextPoint, value));
                    }
                }
            }

            valid.sort(((Comparator<PointValue>) (o1, o2) -> o1.value - o2.value)
                    .thenComparingInt(o -> o.p.x)
                    .thenComparingInt(o -> o.p.y));
            for (PointValue pointValue : valid) {
                result.add(Arrays.asList(pointValue.p.x, pointValue.p.y));

                if (result.size() == k) {
                    return result;
                }
            }

            waiting = nextWaiting;
        }

        return result;
    }

    class PointValue {
        Point p;
        int value;

        public PointValue(Point p, int value) {
            this.p = p;
            this.value = value;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        KHighestRankedItemsWithinAPriceRange solution = new KHighestRankedItemsWithinAPriceRange();
        System.out.println(solution.highestRankedKItems(new int[][]{{2, 0, 2}, {4, 5, 3}, {2, 0, 2}}, new int[]{2, 5}, new int[]{1, 1}, 9));
    }
}
