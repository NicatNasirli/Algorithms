package algorithms.leetcode.topInterview150;

public class HappyNumber {

    /*
    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay),
    or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.
     */

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isHappy(n));
    }


    public static boolean isHappy(int n) {
        int count = 0;
        while (count <= 10) {
            int sum = 0;
            int number = n;
            if (number < 10) sum = (int) Math.pow(number, 2);
            while (number >= 10) {
                sum += (int) Math.pow(number % 10, 2);
                number /= 10;
                if (number < 10) sum += (int) Math.pow(number % 10, 2);
            }
            if (sum == 1) return true;
            n = sum;
            count++;
        }
        return false;
    }
}
