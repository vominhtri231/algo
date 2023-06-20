package tri.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<Segment> sortedSegments = Arrays.stream(intervals)
                .map(Segment::new)
                .sorted()
                .collect(Collectors.toList());

        List<Segment> resultSegments = new ArrayList<>();
        resultSegments.add(sortedSegments.remove(0));

        for (Segment segment : sortedSegments) {
            Segment lastSegment = resultSegments.get(resultSegments.size() - 1);
            if (lastSegment.isOverlapGreaterSegment(segment)) {
                lastSegment.mergeGreaterSegment(segment);
            } else {
                resultSegments.add(segment);
            }
        }

        return resultSegments.stream().map(Segment::toInterval).toArray(int[][]::new);
    }

    static class Segment implements Comparable<Segment> {
        int start;
        int end;

        public Segment(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        @Override
        public int compareTo(Segment segment) {
            return this.start - segment.start;
        }

        public boolean isOverlapGreaterSegment(Segment greaterSegment) {
            return greaterSegment.start <= end;
        }

        public void mergeGreaterSegment(Segment greaterSegment) {
            end = Math.max(greaterSegment.end, end);
        }

        public int[] toInterval() {
            return new int[]{start, end};
        }
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
