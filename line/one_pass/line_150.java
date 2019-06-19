


class Solution {

    /*
     * Time:  O(n)
     * Space: O(n)
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> stack = new ArrayDeque<>();
        String ops = "+-*/";
        for (int i = 0; i < tokens.length; i++) {
            if (!ops.contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            
            int right = stack.pop();
            int left = stack.pop();
            
            String op = tokens[i];
            if (op.equals("+")) {
                stack.push(left + right);
            } else if (op.equals("-")) {
                stack.push(left - right);
            } else if (op.equals("*")) {
                stack.push(left * right);
            } else {
                stack.push(left / right);
            }
        }
        
        return stack.pop();
    }
}