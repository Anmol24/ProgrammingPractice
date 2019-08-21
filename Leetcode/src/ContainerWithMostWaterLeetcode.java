/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWaterLeetcode {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum area is: " + maxArea(arr));
    }

    /**
     * Use 2 pointers to calculate the max area. one starting from the beginning and one from the end.
     * at any point the area would be max of current area or minimum of height at left index and right index multiply by the difference of their index
     * i.e. max(currentMaxArea, min(leftHeight, rightHeight)*(rightIndex-leftIndex); minimum because that much height will be the maximum amount of water it can hold.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length-1;
        while(start < end) {
            maxArea = Math.max(maxArea, (end-start)*Math.min(height[start], height[end]));
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
