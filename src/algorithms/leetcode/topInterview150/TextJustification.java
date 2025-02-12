package algorithms.leetcode.topInterview150;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

//    Given an array of strings words and a width maxWidth,
//    format the text such that each line has exactly maxWidth characters and is fully (left and right)
//    justified.
//
//    You should pack your words in a greedy approach; that is,
//    pack as many words as you can in each line.
//    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//    Extra spaces between words should be distributed as evenly as possible.
//    If the number of spaces on a line does not divide evenly between words,
//    the empty slots on the left will be assigned more spaces than the slots on the right.
//
//    For the last line of text, it should be left-justified,
//    and no extra space is inserted between words.
//
//    Note:
//
//    A word is defined as a character sequence consisting of non-space characters only.
//    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//    The input array words contains at least one word.


    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int wordsLength = words.length;
        int startLineIndex = 0;
        int totalChars = 0;
        int wordCount = 0;
        for (int i = 0; i < wordsLength; i++) {
            if (totalChars + words[i].length() + ((wordCount > 0) ? 1 : 0)> maxWidth) {
                StringBuilder line = new StringBuilder();

                if (wordCount == 1) {
                    line.append(words[startLineIndex]);
                    line.repeat(" ", maxWidth - totalChars);
                } else {
                    int spaceCount = (maxWidth - totalChars) / (wordCount - 1);
                    int extraSpaces = (maxWidth - totalChars) % (wordCount - 1);

                    for (int j = startLineIndex; j < i; j++) {
                        line.append(words[j]);

                        if (j < i - 1) {
                            line.repeat(" ", spaceCount + 1);
                            if (extraSpaces > 0) {
                                line.append(" ");
                                extraSpaces--;
                            }
                        }
                    }
                }

                lines.add(line.toString());
                wordCount = 0;
                totalChars = 0;
                startLineIndex = i;
            }
            if (totalChars != 0) {
                totalChars++;
            }
            totalChars += words[i].length();
            wordCount++;
        }
        StringBuilder lastLine = new StringBuilder();
        for (int i = startLineIndex; i < wordsLength; i++) {
            if (i > startLineIndex) {
                lastLine.append(" ");
            }
            lastLine.append(words[i]);
        }
        lastLine.repeat(" ", maxWidth - lastLine.length());
        lines.add(lastLine.toString());

        return lines;
    }
}
