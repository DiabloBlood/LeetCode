


public class Solution20 {
    /**
     * Notes:
     *     1. This method only faster than 98.56% other's code in leetcode.
     *     2. `stack.pop()` will not influence final `return stack.isEmpty()` result (consider case "(]"),
     *        since if `!isMatch(stack.pop(), c)`, `false` already returned in advance.
     *
     * General Cases:
     *     1. c == left;                                                  ---> stack.push(c);
     *     2. c == right && !stack.isEmpty() && isMatch(stack.pop(), c);  ---> continue;
     *     3. c == right && !stack.isEmpty() && !isMatch(stack.pop(), c); ---> return false;
     *     4. c == right && stack.isEmpty();                              ---> return false;
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `s.length()` will throw `NullPointerException`.
     *
     * Time:  best  O(1), like ")))))".
     *        worst O(n), like "(((((", "((()))", "(((()", etc.
     *        avg   O(n)
     * Space: best  O(1), like ")))))", "()()()", etc.
     *        worst O(n), like "(((((".
     *        avg   O(n)
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && isMatch(stack.pop(), c)) {
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char p, char q) {
        return p == '(' && q == ')' || p == '[' && q == ']' || p == '{' && q == '}';
    }

    /**
     * Notes:
     *     1. This method only faster than 10.20% other's code in leetcode.
     *     2. Reason is `stack.peek()` and `stack.pop()` are duplicate calls.
     *
     * General Cases:
     *     1. c == left;                                  ---> stack.push(c);
     *     2. c == right && !stack.isEmpty() && isMatch;  ---> stack.pop();
     *     3. c == right && !stack.isEmpty() && !isMatch; ---> return false;
     *     4. c == right && stack.isEmpty();              ---> return false;
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `s.length()` will throw `NullPointerException`.
     *
     * Time:  best  O(1), like ")))))".
     *        worst O(n), like "(((((", "((()))", "(((()", etc.
     *        avg   O(n)
     * Space: best  O(1), like ")))))", "()()()", etc.
     *        worst O(n), like "(((((".
     *        avg   O(n)
     */
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
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char p, char q) {
        return p == '(' && q == ')' || p == '[' && q == ']' || p == '{' && q == '}';
    }

    /**
     * Problem: if input only has '(' or ')'.
     *
     * General Cases:
     *     1. c == '(';                     ---> stack.push(c);
     *     2. c == ')' && !stack.isEmpty(); ---> stack.pop();
     *11     3. c == ')' && stack.isEmpty();  ---> return false;
     *
     * Corner Cases:
     *     1. s == null; ---> return false; // otherwise `s.length()` will throw `NullPointerException`.
     *
     * Time:  best  O(1), like ")))))".
     *        worst O(n), like "(((((", "((()))", "(((()", etc.
     *        avg   O(n)
     * Space: best  O(1), like ")))))", "()()()", etc.
     *        worst O(n), like "(((((".
     *        avg   O(n)
     */
    public boolean isValid(String s) {
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
