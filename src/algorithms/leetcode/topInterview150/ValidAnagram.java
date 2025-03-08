package algorithms.leetcode.topInterview150;

import java.util.Arrays;

public class ValidAnagram {
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        isAnagram(s, t);
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length()!= t.length()) return false;
        int[] sCharSet = new int[26];
        int[] tCharSet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharSet[s.charAt(i) - 'a']++;
            tCharSet[t.charAt(i) - 'a']++;
        }

        int index = 0;
        while (index < 26) {
            if (sCharSet[index] != tCharSet[index]) return false;
            index++;
        }
        return true;
    }
}
