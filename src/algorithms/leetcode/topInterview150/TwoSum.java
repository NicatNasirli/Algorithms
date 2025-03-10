package algorithms.leetcode.topInterview150;

import java.util.*;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int missing = target - nums[i];
            if (indicesMap.containsKey(missing)) return new int[]{indicesMap.get(missing), i};
            indicesMap.put(nums[i], i);
        }
        return null;
    }
}
