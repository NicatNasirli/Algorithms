package algorithms.leetcode.topInterview150;

public class IsSubsequence {

//    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//    A subsequence of a string is a new string that is formed from the original string by
//    deleting some (can be none) of the characters without disturbing the relative positions of the
//    remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not)


    public static void main(String[] args) {
        String s = "b", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();
        while (tIndex < tLength){
            if (sIndex >= sLength) break;
            if (s.charAt(sIndex) == t.charAt(tIndex)) sIndex++;
            tIndex++;
        }
        return sIndex == sLength;
    }
}
