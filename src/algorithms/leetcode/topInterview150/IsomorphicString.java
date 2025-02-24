package algorithms.leetcode.topInterview150;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
     */


    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sCharacter = s.charAt(i);
            char tCharacter = t.charAt(i);

            if (sMap.containsKey(sCharacter) && sMap.get(sCharacter) != tCharacter) return false;
            if (tMap.containsKey(tCharacter) && tMap.get(tCharacter) != sCharacter) return false;

            sMap.put(sCharacter, tCharacter);
            tMap.put(tCharacter, sCharacter);
        }

        return true;
    }
}
