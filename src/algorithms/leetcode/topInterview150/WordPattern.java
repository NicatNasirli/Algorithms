package algorithms.leetcode.topInterview150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    /*
    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.
    */

    public static void main(String[] args) {
        String pattern = "abba", s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> wordPatterns = new HashMap<>();
        String[] sWords = s.split(" ");
        int patternLength = pattern.length();
        if (patternLength != sWords.length) return false;
        for (int i = 0; i < patternLength; i++) {
            if (!wordPatterns.containsValue(sWords[i]) && !wordPatterns.containsKey(pattern.charAt(i)))
                wordPatterns.put(pattern.charAt(i), sWords[i]);
        }
        for (int i = 0; i < patternLength; i++) {
            if (!wordPatterns.containsKey(pattern.charAt(i))) return false;
            else if (!wordPatterns.get(pattern.charAt(i)).equals(sWords[i])) return false;
        }
        return true;
    }
}
