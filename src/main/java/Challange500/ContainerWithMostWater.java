package Challange500;

/**Approach 2: Two Pointer Approach
 Algorithm

 The intuition behind this approach is that the area formed between the lines will always be limited by the
 height of the shorter line. Further, the farther the lines, the more will be the area obtained.

 We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
 Further, we maintain a variable maxarea to store the maximum area obtained till now. At every step,
 we find out the area formed between them, update maxarea, and move the pointer pointing to the shorter
 line towards the other end by one step.

 Initially, we consider the area constituting the exterior most lines. Now, to maximize the area,
 we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards,
 we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's
 pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width.
 This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome
 the reduction in area caused by the width reduction.
 * */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, area);
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(arr));
    }
}
