package algorithms.leetcode.topInterview150;

import java.util.*;

public class SimplifyPath {

    /*
    You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
    Your task is to transform this absolute path into its simplified canonical path.

    The rules of a Unix-style file system are as follows:

    A single period '.' represents the current directory.
    A double period '..' represents the previous/parent directory.
    Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    Any sequence of periods that does not match the rules above should be treated as a valid directory or file name.
    For example, '...' and '....' are valid directory or file names.
    The simplified canonical path should follow these rules:

    The path must start with a single slash '/'.
    Directories within the path must be separated by exactly one slash '/'.
    The path must not end with a slash '/', unless it is the root directory.
    The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
    Return the simplified canonical path.
     */


    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();
        StringBuilder element = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            char character = path.charAt(i);
            if (character == '/') {
                if (element.length() > 0) {
                    String elementToString = element.toString();
                    if (elementToString.equals("..")){
                        if (!pathStack.isEmpty()) pathStack.pop();
                    }else if (!elementToString.equals(".")) pathStack.push(elementToString);
                    element.setLength(0);
                }
            } else element.append(character);
        }

        if (element.length() > 0) {
            String dir = element.toString();
            if (dir.equals("..")) {
                if (!pathStack.isEmpty()) pathStack.pop();
            } else if (!dir.equals(".")) {
                pathStack.push(dir);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String el : pathStack) {
            simplifiedPath.append("/").append(el);
        }

        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}
