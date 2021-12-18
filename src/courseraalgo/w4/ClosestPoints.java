package courseraalgo.w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ClosestPoints {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point other) {
            int dx = x - other.x;
            int dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        Point[] pointXs = createPoints(x, y, Comparator.comparingInt(p -> p.x));
        Point[] pointYs = createPoints(x, y, Comparator.comparingInt(p -> p.y));
        return minimumDistance(pointXs, pointYs, 0, pointXs.length - 1);
    }

    private static Point[] createPoints(int[] x, int[] y, Comparator<Point> comparator) {
        int length = x.length;
        Point[] points = new Point[length];
        for (int i = 0; i < length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        Arrays.sort(points, comparator);
        return points;
    }

    private static double minimumDistance(Point[] pointXs, Point[] pointYs, int start, int end) {
        if (start + 1 == end) {
            return pointXs[start].distance(pointXs[end]);
        }

        if (start == end) {
            return Double.POSITIVE_INFINITY;
        }

        int mid = (start + end) / 2;
        double minDistanceGroup = Math.min(
                minimumDistance(pointXs, pointYs, start, mid),
                minimumDistance(pointXs, pointYs, mid + 1, end));

        Point[] middlePoints = getMiddlePoints(pointXs, pointYs, mid, minDistanceGroup);
        double minDistanceMiddlePoints = getMiddlePointMinDistance(middlePoints);
        return Math.min(minDistanceMiddlePoints, minDistanceGroup);
    }

    private static Point[] getMiddlePoints(Point[] pointXs, Point[] pointYs, int mid, double minGroup) {
        double separateX = (pointXs[mid].x + pointXs[mid + 1].x) / 2.0;
        double lowerBound = separateX - minGroup;
        double upperBound = separateX + minGroup;
        return Arrays.stream(pointYs)
                .filter(point -> point.x >= lowerBound && point.x <= upperBound)
                .toArray(Point[]::new);
    }

    private static double getMiddlePointMinDistance(Point[] middlePoints) {
        double minDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < middlePoints.length; i++) {
            Point handlingPoint = middlePoints[i];
            int limit = Math.min(middlePoints.length, i + 7);

            for (int j = i + 1; j < limit; j++) {
                double distance = handlingPoint.distance(middlePoints[j]);
                if (minDistance > distance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimumDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
