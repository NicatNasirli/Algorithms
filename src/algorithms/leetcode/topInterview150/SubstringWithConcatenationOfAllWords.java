package algorithms.leetcode.topInterview150;

import java.util.*;
import java.util.function.BiConsumer;

public class SubstringWithConcatenationOfAllWords {

    /*
    You are given a string s and an array of strings words. All the strings of words are of the same length.

    A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

    For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
    "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
    Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
     */


    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        int wordLength = words[0].length(), wordsLength = words.length;
        int substringLength = wordLength * wordsLength;

        Map<Integer, Map<String, Integer>> substringsWithIndicesMap = new HashMap<>();

        Map<String, Integer> wordCountsOfArray = new HashMap<>();
        for (String word : words) {
            wordCountsOfArray.put(word, wordCountsOfArray.getOrDefault(word, 0) + 1);
        }

        int left = 0, right = substringLength;
        while (right <= s.length()){
            Map<String, Integer> substringCounts = new HashMap<>();
            StringBuilder word = new StringBuilder();
            for (int j = left; j < right; j++) {
                if ((j - left + 1) % wordLength == 0) {
                    word.append(s.charAt(j));
                    substringCounts.put(word.toString(), substringCounts.getOrDefault(word.toString(), 0) + 1);
                    word = new StringBuilder();
                    continue;
                }
                word.append(s.charAt(j));
            }
            substringsWithIndicesMap.put(left, substringCounts);
            right++;
            left++;
        }

        Set<Integer> substringsIndices = substringsWithIndicesMap.keySet();
        Set<String> wordCounts = wordCountsOfArray.keySet();

        for (Integer index : substringsIndices) {
            int counter = 0;
            Map<String, Integer> returnedString = substringsWithIndicesMap.get(index);
            for (String word : wordCounts) {
                if (returnedString.containsKey(word)) {
                    int wordCount = returnedString.get(word);
                    if (wordCountsOfArray.get(word) == wordCount) {
                        counter += wordCount;
                    } else break;
                } else break;
            }
            if (counter == wordsLength) indices.add(index);
        }

        return indices;
    }


    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        int wordsLength = words.length, wordLength = words[0].length();
        int stringLength = wordsLength * wordLength;
        int left = 0, right = stringLength;
        Map<Integer, Map<String, Integer>> substrings = new HashMap<>();
        Map<String, Integer> wordsCounts = new HashMap<>();

        for (String word : words) {
            wordsCounts.put(word, wordsCounts.getOrDefault(word, 0) + 1);
        }

        while (right <= s.length()) {
            Map<String, Integer> string = new HashMap<>();
            String substring = s.substring(left, right);
            int counter = 1;
            StringBuilder word = new StringBuilder();
            for (int i = 0; i <= stringLength; i++) {
                if (i == counter * wordLength) {
                    string.put(word.toString(), string.getOrDefault(word.toString(), 0) + 1);
                    word = new StringBuilder();
                    counter++;
                }
                if (i == stringLength) break;
                word.append(substring.charAt(i));
            }
            substrings.put(left, string);
            left++;
            right++;
        }
        Set<Integer> substringsIndices = substrings.keySet();
        Set<String> wordCounts = wordsCounts.keySet();

        for (Integer index : substringsIndices) {
            int counter = 0;
            Map<String, Integer> returnedString = substrings.get(index);
            for (String word : wordCounts) {
                if (returnedString.containsKey(word)) {
                    int wordCount = returnedString.get(word);
                    if (wordsCounts.get(word) == wordCount) {
                        counter += wordCount;
                    } else break;
                } else break;
            }
            if (counter == wordsLength) indices.add(index);
        }
        System.out.println(substrings);


        return indices;
    }
}
