package tri.algo.leetcode;

public class JumpGameII {

    public int jump(int[] nums) {
        int[] minJump = new int[nums.length];
        minJump[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = 1_000_000;
            for (int j = 1; j <= nums[i] && j + i < nums.length; j++) {
                min = Math.min(min, minJump[j + i]);
            }

            minJump[i] = min + 1;
        }

        return minJump[0];
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
    }
}
