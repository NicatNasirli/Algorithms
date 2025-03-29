package algorithms.leetcode.topInterview150;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.
     */

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> tokensStack = new Stack<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")) {
                tokensStack.push(token);
            } else {
                String right = tokensStack.pop();
                String left = tokensStack.pop();

                int newToken = getNewToken(token, left, right);

                tokensStack.push(String.valueOf(newToken));
            }
        }

        return Integer.parseInt(tokensStack.peek());
    }

    private static int getNewToken(String token, String left, String right) {
        char expression = token.charAt(0);
        int newToken;
        if (expression == '+') {
            newToken = Integer.parseInt(left) + Integer.parseInt(right);
        } else if (expression == '-') {
            newToken = Integer.parseInt(left) - Integer.parseInt(right);
        } else if (expression == '/') {
            newToken = Integer.parseInt(left) / Integer.parseInt(right);
        } else {
            newToken = Integer.parseInt(left) * Integer.parseInt(right);
        }
        return newToken;
    }
}
