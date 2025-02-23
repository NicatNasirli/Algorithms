package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

/*
    Given an array of positive integers nums and a positive integer target,
    return the minimal length of a subarray
    whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

    public static void main(String[] args) {
        int target = 213;
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int numsLength = nums.length;
        int minLength = numsLength;
        for (int i = numsLength - 1; i >= 0; i--) {
            int sum = 0;
            int currentMin = 0;

            //if the biggest element is bigger than target
            if (nums[i] >= target) return 1;

            for (int j = i; j >= 0; j--) {
                if (sum < target) {
                    currentMin++;
                } else {
                    if (currentMin < minLength) minLength = currentMin;
                    break;
                }
                sum += nums[j];
                if (i == numsLength - 1 && j == 0 && sum < target) return 0;
            }

        }
        return minLength;
    }
}
