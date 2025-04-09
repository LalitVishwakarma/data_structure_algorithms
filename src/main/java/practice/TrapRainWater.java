package practice;

public class TrapRainWater {

    public static int trap(int[] height) {
        int sum = 0;
        int leftMax = height[0], l = 0;
        int rightMax = height[height.length - 1], r = height.length - 1;
        while(l < r) {
            if(leftMax < rightMax) {
                l++;
                if(height[l] > leftMax)
                    leftMax = height[l];
                sum += leftMax - height[l];
            } else {
                r--;
                if(height[r] > rightMax)
                    rightMax = height[r];
                sum += rightMax - height[r];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
