package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class MergeSortedArray {

//    You are given two integer arrays nums1 and nums2,
//    sorted in non-decreasing order, and two integers m and n,
//    representing the number of elements in nums1 and nums2 respectively.

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int n = 3, m = 3;

        merge(nums1, m, nums2, n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        int nums1Index = m - 1, nums2Index = n - 1;
        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[count] = nums1[nums1Index];
                nums1Index--;
            } else {
                nums1[count] = nums2[nums2Index];
                nums2Index--;
            }
            count--;
        }
        while (nums2Index >= 0) {
            nums1[count] = nums2[nums2Index];
            nums2Index--;
            count--;
        }
    }
}
