package algorithms.leetcode.topInterview150;

import java.util.*;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
     */

    public static void main(String[] args) {
        String s = "([}}])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0 || length <= 1) return false;

        Deque<Character> characterStack = new ArrayDeque<>();
        Map<Character, Character> bracketsMap = Map.of('(', ')', '{', '}', '[', ']');

        for (char bracket : s.toCharArray()) {
            if (bracketsMap.containsKey(bracket)) {
                characterStack.push(bracket);
            } else {
                if (characterStack.isEmpty()) return false;
                char top = characterStack.pop();
                if (bracketsMap.get(top) != bracket) return false;
            }
        }

        return characterStack.isEmpty();
    }
}
