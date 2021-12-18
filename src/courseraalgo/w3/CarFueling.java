package courseraalgo.w3;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int[] fullStops = createFullStops(dist, stops);
        int currentStop = 0;
        int numberRefill = 0;

        while (currentStop < fullStops.length - 1) {
            int lastStop = currentStop;
            while (currentStop + 1 < fullStops.length
                    && fullStops[currentStop + 1] - fullStops[lastStop] <= tank)
                currentStop++;
            if (currentStop == lastStop) {
                return -1;
            }
            numberRefill++;
        }

        return numberRefill - 1;
    }

    static int[] createFullStops(int dist, int[] stops) {
        int[] fullStops = new int[stops.length + 2];
        fullStops[0] = 0;
        fullStops[stops.length + 1] = dist;
        System.arraycopy(stops, 0, fullStops, 1, stops.length);
        return fullStops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
