package algorithms.leetcode.topInterview150;

import java.util.*;

public class LongestConsecutiveSequence {

    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

    You must write an algorithm that runs in O(n) time.
     */

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            integerSet.add(num);
        }

        int length = integerSet.size();
        int[] sortedNums = new int[length];
        int index = 0;
        for (int num : integerSet) {
            sortedNums[index] = num;
            index++;
        }
        Arrays.sort(sortedNums);
        int longestConsecutiveTemporary = 1, longestConsecutive = longestConsecutiveTemporary;
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                if (sortedNums[i] + 1 == sortedNums[i + 1]) longestConsecutiveTemporary++;
                else {
                    longestConsecutiveTemporary = 1;
                }
            }
            longestConsecutive = Math.max(longestConsecutive, longestConsecutiveTemporary);
        }
        return longestConsecutive;
    }
}
