import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}

public class Test {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int count = 0;
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            System.out.println(stack.toString());
            while (!stack.isEmpty()) {
                if (stack.peek().right != null && stack.peek().right != cur) {
                    cur = stack.peek().right;
                    break;
                }
                cur = stack.pop();
                result.add(cur.val);
            }
            count++;
            if (count > 8) {
                break;
           }
        } while (!stack.isEmpty());
        System.out.println(result.toString());
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        Test test = new Test();
        test.postorderTraversal(root);
    }
}












