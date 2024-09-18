package algorithms.leetcode.topInterview150;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums,k)));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
