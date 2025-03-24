package algorithms.leetcode.topInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    /*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
    and the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
    and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

    Return intervals after the insertion.

    Note that you don't need to modify intervals in-place. You can make a new array and return it.
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ints = insert(intervals, newInterval);
        for (int[] interval : ints) {
            System.out.println(Arrays.toString(interval));
        }
    }

    //    currentInterval[0] <= intervals[i][0] && currentInterval[1] >= intervals[i][0]
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        int i = 0, length = intervals.length;

        while (i < length && intervals[i][1] < newInterval[0]) {
            intervalsList.add(intervals[i]);
            i++;
        }

        while (i < length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        intervalsList.add(newInterval);

        while (i < length) {
            intervalsList.add(intervals[i]);
            i++;
        }

        return intervalsList.toArray(new int[intervalsList.size()][2]);
    }
}
