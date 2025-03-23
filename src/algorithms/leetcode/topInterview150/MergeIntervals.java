package algorithms.leetcode.topInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = merge(intervals);
        for (int[] interval : ints) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals; //is empty or only one interval

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> intervalsList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] >= currentInterval[0] && currentInterval[1] >= intervals[i][0]) {
                currentInterval[0] = Math.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                intervalsList.add(currentInterval);
                currentInterval = intervals[i];
            }

        }
        intervalsList.add(currentInterval);

        return intervalsList.toArray(new int[intervalsList.size()][2]);
    }
}
