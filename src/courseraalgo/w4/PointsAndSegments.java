package courseraalgo.w4;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static class Segment implements Comparable<Segment> {
        int start;
        int end;

        @Override
        public int compareTo(Segment o) {
            return start - o.start;
        }

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        Segment[] segments = createSortedSegments(starts, ends);

        int length = points.length;
        int[] counts = new int[length];
        for (int i = 0; i < points.length; i++) {
            counts[i] = countSegment(segments, points[i]);
        }

        return counts;
    }

    private static Segment[] createSortedSegments(int[] starts, int[] ends) {
        int length = starts.length;
        Segment[] segments = new Segment[length];
        for (int i = 0; i < starts.length; i++) {
            segments[i] = new Segment(starts[i], ends[i]);
        }
        Arrays.sort(segments);
        return segments;
    }

    private static int countSegment(Segment[] segments, int point) {
        int startNotGreaterIndex = getStartNotGreaterIndex(segments,
                0, segments.length - 1, point);
        int count = 0;
        for (int i = 0; i <= startNotGreaterIndex; i++) {
            if (segments[i].end >= point) {
                count++;
            }
        }
        return count;
    }

    private static int getStartNotGreaterIndex(Segment[] segments, int low, int high, int point) {
        while (high >= low) {
            int mid = low + (high - low) / 2;
            int midValue = segments[mid].start;
            if (midValue == point) {
                while (mid + 1 <= high && segments[mid + 1].start == point) {
                    mid++;
                }
                return mid;
            }
            if (point > midValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

