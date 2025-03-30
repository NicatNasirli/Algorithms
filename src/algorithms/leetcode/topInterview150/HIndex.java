package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class HIndex {


    /*
    Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

    According to the definition of h-index on Wikipedia:
    The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
     */


    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5}; //0,1,3,5,6
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int h = length - i;
            if (citations[i] >= h) return h;
        }

        return 0;
    }
}
