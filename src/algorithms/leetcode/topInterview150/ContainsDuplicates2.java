package algorithms.leetcode.topInterview150;

public class ContainsDuplicates2 {

    /*
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j
    in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        containsNearbyDuplicate(nums, k);
    }


    //more memory efficient
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length && j <= k + i ; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
