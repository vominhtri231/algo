package tri.algo.leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] canJumpPositions = new boolean[nums.length];
        canJumpPositions[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {

            for (int step = 1; step <= nums[i]; step++) {
                if (canJumpPositions[step + i]) {
                    canJumpPositions[i] = true;
                    break;
                }
            }
        }

        return canJumpPositions[0];
    }

    public boolean canJump2(int[] nums) {
        int max = nums[0];
        int i = 1;
        for (; i <= max && i < nums.length; i++) {
            max = Math.max(i + nums[i], max);
        }

        return i == nums.length;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        System.out.println(solution.canJump2(new int[]{3, 2, 1, 0, 4}));
    }
}
