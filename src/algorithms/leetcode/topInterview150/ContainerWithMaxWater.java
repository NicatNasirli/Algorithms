package algorithms.leetcode.topInterview150;

public class ContainerWithMaxWater {

//    You are given an integer array height of length n.
//    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//    Find two lines that together with the x-axis form a container,
//    such that the container contains the most water.
//
//    Return the maximum amount of water a container can store.
//
//    Notice that you may not slant the container.


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,7,3,2};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int amount = 0;
        while (left < right) {
            int base = right - left;
            int side = Math.min(height[left], height[right]);
            amount = Math.max(amount, base * side);

            if (height[left] < height[right]) left++;
            else right--;
        }
        return amount;
    }
}
