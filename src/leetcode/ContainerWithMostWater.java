package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = calculateArea(height, l, r);

        while (l < r) {
            if (height[l] < height[r]) {
                l = l + 1;
            } else {
                r = r - 1;
            }

            maxArea = Math.max(calculateArea(height, l, r), maxArea);
        }

        return maxArea;
    }

    private int calculateArea(int[] height, int start, int end) {
        return (end - start) * Math.min(height[start], height[end]);
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1,2,1}));
    }
}
