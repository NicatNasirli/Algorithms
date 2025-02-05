package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class Candy {

//    There are n children standing in a line.
//    Each child is assigned a rating value given in the integer array ratings.
//
//    You are giving candies to these children subjected to the following requirements:
//
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//    Return the minimum number of candies you need to have to distribute the candies to the children.

    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        System.out.println(candy(ratings));
    }


    public static int candy(int[] ratings) {
        int length = ratings.length;
        int totalCandy = 0;
        int[] candies = new int[length];
        candies[0] = 1;

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = 1 + candies[i - 1];
            }else candies[i] = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            totalCandy += candies[i];
        }
        totalCandy += candies[length - 1];

        System.out.println(Arrays.toString(candies));
        return totalCandy;
    }
}
