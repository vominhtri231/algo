package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingWindowMaxium {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        WindowState currentState = new WindowState(nums, k);

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i + k <= nums.length; i++) {
            if (i > 0) {
                currentState.moveToLeft(i);
            }
            result[i] = currentState.getMax();
        }

        return result;
    }


    static class WindowState {
        List<Integer> current;
        int[] nums;
        int k;

        WindowState(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            current = Arrays.stream(nums, 0, k).sorted().boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        void moveToLeft(int leftIndex) {
            int removeValue = nums[leftIndex - 1];
            int removedPosition = Collections.binarySearch(current, removeValue);
            current.remove(removedPosition);

            int insertValue = nums[leftIndex + k - 1];
            int insertPosition = Collections.binarySearch(current, insertValue);
            if (insertPosition < 0) {
                insertPosition = -insertPosition - 1;
            }
            current.add(insertPosition, insertValue);
        }

        int getMax() {
            return current.get(k - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 11}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, -2}, 2)));
    }

}
