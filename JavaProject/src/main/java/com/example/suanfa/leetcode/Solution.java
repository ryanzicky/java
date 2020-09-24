package com.example.suanfa.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @Author zhourui
 * @Date 2019/10/28 14:24
 */
public class Solution {

    public static void main(String[] args){
        boolean valid = isValid("{[()]}");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
