package algorithms.leetcode.topInterview150;

import java.util.*;

public class GroupAnagrams {

    // Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new ArrayList<>();
        Set<String> sortedStrsSet = new HashSet<>();
        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            sortedStrsSet.add(sorted);
            sortedStrs[i] = sorted;
        }
        for (String s : sortedStrsSet) {
            List<String> anagrams = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (s.equals(sortedStrs[i])) anagrams.add(strs[i]);
            }
            anagramsList.add(anagrams);
        }

        return anagramsList;
    }

}
