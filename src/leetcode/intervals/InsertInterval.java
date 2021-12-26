package leetcode.intervals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Segment> sortedSegments = Arrays.stream(intervals).map(Segment::new).collect(Collectors.toList());
        Segment insertSegment = new Segment(newInterval);
        int insertPosition = getInsertPosition(sortedSegments, insertSegment);


    }

    private int getInsertPosition(List<Segment> sortedSegment, Segment segment) {
        int l = 0;
        int r = sortedSegment.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (sortedSegment.get(mid).start < segment.start) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
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
}
