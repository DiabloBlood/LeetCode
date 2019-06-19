
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

import java.util.ArrayDeque;
import java.util.Deque;


/*
* Case Analysis:
* 1. stack.isEmpty() && c in ['(', '[', '{'], stack.push(c)
* 2. !stack.isEmpty() && c in ['(', '[', '{'], stack.push(c)    Example: ((()))
* 3. stack.isEmpty() && c in [')', ']', '}'], return false
* 4. !stack.isEmpty() && c in [')', ']', '}'] && isMatch(stack.peek(), c)), stack.pop()
* 5. !stack.isEmpty() && c in [')', ']', '}'] && !isMatch(stack.peek(), c)), return false not match only because (] mismatch
*/



public class Solution20 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                stack.pop();
            } else {
                // case 1: '(]'
                // if not go branch 1, which means c == ')' || c == ']' || c == '}', if stack is empty now, then failed
                return false;
            }
        }
        return stack.isEmpty();
    }

    private isMatch(char p, char q) {
        return p == '(' && q == ')' || p == '[' && q == ']' || p == '{' && q == '}'; 
    }

    // Suppose s only have '(' and ')'
    /*
    * Case Analysis:
    * 1. stack.isEmpty() && c == '('; stack.push(c);
    * 2. !stack.isEmpty() && c == '('; stack.push(c);    Example: ((()))
    * 3. stack.isEmpty() && c == ')'; return false;
    * 4. !stack.isEmpty() && c == ')'; stack.pop()
    */
    public boolean isValid2(String s) {
        if (s == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}












