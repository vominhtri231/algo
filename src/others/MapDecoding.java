package others;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapDecoding {
    int mapDecoding(String message) {
        Set<String> accepted = IntStream.range(1, 27).mapToObj(i -> i + "").collect(Collectors.toSet());

        int length = message.length();
        int[] results = new int[length + 1];
        results[0] = 1;
        for (int i = 1; i <= length; i++) {
            int first = i - 1 >= 0 && accepted.contains(message.substring(length - i, length - i + 1)) ? results[i - 1] : 0;
            int second = i - 2 >= 0 && accepted.contains(message.substring(length - i, length - i + 2)) ? results[i - 2] : 0;
            results[i] = (first + second) % 1000000007;
        }

        return results[length];
    }

    public static void main(String[] args) {
        MapDecoding mapDecoding = new MapDecoding();
        System.out.println(mapDecoding.mapDecoding("1261"));
    }
}
