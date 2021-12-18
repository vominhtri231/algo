package leetcode;

import java.util.BitSet;

public class SeatManager {
    BitSet seats;

    public SeatManager(int n) {
        seats = new BitSet(n);
    }

    public int reserve() {
        int empty = seats.nextClearBit(0);
        seats.set(empty);
        return empty + 1;
    }

    public void unreserve(int seatNumber) {
        seats.clear(seatNumber - 1);
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);

        System.out.println();
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        System.out.println(seatManager.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        System.out.println(seatManager.reserve());    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        System.out.println(seatManager.reserve());    // The available seats are [4,5], so return the lowest of them, which is 4.
        System.out.println(seatManager.reserve());    // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
