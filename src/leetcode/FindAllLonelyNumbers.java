package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllLonelyNumbers {

    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            for (; j < nums.length && nums[j] <= nums[i] + 1; j++) ;

            if (j == i + 1 && (i == 0 || nums[i - 1] + 1 < nums[i])) {
                result.add(nums[i]);
            }
            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllLonelyNumbers solution = new FindAllLonelyNumbers();
        System.out.println(solution.findLonely(new int[]{75, 35, 59, 66, 69, 53, 37, 16, 60, 98, 11, 33, 3, 85, 59, 65, 59, 44, 34, 89, 72, 47}));
    }
}
