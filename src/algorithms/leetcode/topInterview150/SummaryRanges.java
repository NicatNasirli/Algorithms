package algorithms.leetcode.topInterview150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /*
    You are given a sorted unique integer array nums.

    A range [a,b] is the set of all integers from a to b (inclusive).

    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
     That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 3,4, 6, 7, 9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> rangesList = new ArrayList<>();
        if (length == 0) return rangesList;
        int left = nums[0], right = nums[0];
        for (int i = 0; i < length; i++) {
            if (i + 1 < length) {
                if (nums[i] + 1 == nums[i + 1]) {
                    right = nums[i + 1];
                }else {
                    if (left == right) rangesList.add(left + "");
                    else rangesList.add(left + "->" + right);
                    left = nums[i + 1];
                    right = left;
                }
            }else {
                if (left != right) rangesList.add(left + "->" + right);
                else rangesList.add(left + "");
            }

        }
        return rangesList;
    }
}
