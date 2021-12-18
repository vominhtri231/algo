package courseraalgo.w3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    private static Integer[] optimalPoints(Segment[] segments) {
        List<Segment> segs = getSegmentList(segments);
        List<Integer> cutPoints = new ArrayList<>();

        while (segs.size() > 0) {
            int cutPoint = segs.get(0).end;
            segs.removeIf(segment -> segment.start <= cutPoint);
            cutPoints.add(cutPoint);
        }
        return cutPoints.toArray(new Integer[0]);
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            return end - o.end;
        }
    }

    private static List<Segment> getSegmentList(Segment[] segments) {
        Arrays.sort(segments);
        List<Segment> list = new ArrayList<>();
        Collections.addAll(list, segments);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        Integer[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
