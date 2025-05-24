package Challange500;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        int n = height.length;
        int maxRight = height[n - 1], r = n - 1;
        int maxLeft = height[0], l = 0;
        int sum = 0;
        while (l < r) {
            if(maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                sum += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                sum += maxRight - height[r];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater42.trap(height));
    }
}
