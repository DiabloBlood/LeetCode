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
}

public class Test {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        boolean to = false;
        int count = 0;
        while (cur != root || to == false) {
            to = true;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //now cur == null
            while (!stack.isEmpty()) {
                if (stack.peek().right != null) {
                    cur = stack.peek().right;
                    break;
                }
                cur = stack.pop();
                result.add(cur.val);
                System.out.println(cur.val);
                count++;
            }
            if (count > 8) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Test test = new Test();
        test.postorderTraversal(root);
    }
}












