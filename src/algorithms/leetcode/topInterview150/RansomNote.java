package algorithms.leetcode.topInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RansomNote {

    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by
    using the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.
     */

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "abb";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charactersCount = new int[26];

        for (char character : magazine.toCharArray()) charactersCount[character - 'a']++;

        for (char character : ransomNote.toCharArray()) {
            if (charactersCount[character - 'a'] == 0) return false;
            else charactersCount[character - 'a']--;
        }
        return true;
    }
}

