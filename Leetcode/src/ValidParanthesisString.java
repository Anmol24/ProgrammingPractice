package com.anmol.service;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 */
public class ValidParanthesisString {
    /**
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> asterickStack = new Stack<>();

        for(int i = 0; i<s.length();i++) {
            if(s.charAt(i) == '(') {
                openStack.push(i);
            } else if(s.charAt(i) == '*') {
                asterickStack.push(i);
            } else {
                if(!openStack.empty()) {
                    openStack.pop();
                } else if(!asterickStack.empty()) {
                    asterickStack.pop();
                } else {
                    return false;
                }
            }
        }
        if(openStack.isEmpty()) {
            return true;
        }
        if(asterickStack.isEmpty()) {
            return false;
        } else {
            while (!asterickStack.empty() && !openStack.empty()) {
                int a = asterickStack.pop();
                int o = openStack.pop();
                if(a<o) {
                    return false;
                }

            }
            return openStack.empty();
        }
    }

    public static void main(String[] args) {
        ValidParanthesisString validParanthesisString = new ValidParanthesisString();
        System.out.println(validParanthesisString.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
