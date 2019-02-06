


public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = getPivotIndex(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right); // swap pivot to rightmost first
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] > pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right); // swap back pivot
        return leftBound;
    }

    private int getPivotIndex(int left, int right) {
        int range = right - left + 1;
        return (int) (Math.random() * range) + left;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}



//Given a singly-linked list, where each node contains an integer value, sort it in 
//ascending order. The quick sort algorithm should be used to solve this problem.
//
//Examples
//
//null, is sorted to null
//1 -> null, is sorted to 1 -> null
//1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6

public class QuickSortLinkedList {

    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode left, ListNode right) {
        if (left == null || left == right || left.next == right) {
            return left;
        }
        ListNode[] result = partition(left, right);
        ListNode leftResult = quickSort(result[0], result[1]);
        ListNode rightResult = quickSort(result[1].next, right);
        return leftResult;
    }
    
    // 2 -> 4 -> 1 -> 3 -> null
    // l                   r
    //      p    t
    // dummy -> 2 -> 4 -> null
    
    // left is inclusive, right is exclusive
    // this method sorts the nodes based on the first node's value.
    // it returns the new start node and the pivot node.
    private ListNode[] partition(ListNode left, ListNode right) {
        if (left == null || left == right || left.next == right) {
            return new ListNode[] {left, right};
        }
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        ListNode pre = left;
        while (pre != null && pre.next != null && pre.next != right) {
            // find nodes smaller than left
            if (pre.next.value < left.value) {
                // detach the smaller node
                ListNode smaller = pre.next;
                pre.next = smaller.next;
                // append the smaller node to the head
                smaller.next = dummy.next;
                dummy.next = smaller;
            } else {
                pre = pre.next;
            }
        }
        return new ListNode[] { dummy.next, left };
    }
}



//Given a singly-linked list, where each node contains an integer value, sort it in 
//ascending order. The selection sort algorithm should be used to solve this problem.
//
//Examples
//
//null, is sorted to null
//1 -> null, is sorted to 1 -> null
//1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to 2 -> 3 -> 4 -> 5 -> 6

public class SelectionSortLinkedList {

    public ListNode selectionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null) {
            ListNode pre = head;
            ListNode curMin = head;
            ListNode curHead = head;
            // get the previous of min node and the min node for the current round
            while (curHead.next != null) {
                if (curHead.next.value < curMin.value) {
                    pre = curHead;
                    curMin = curHead.next;
                }
                curHead = curHead.next;
            }
            // detach the min node from the original list
            ListNode next = curMin.next;
            curMin.next = null;
            pre.next = next;
            // append the min node after the current dummy
            cur.next = curMin;
            cur = cur.next;
            // move head to next for next round if the current removed min is not
            // at the head which is pre
            if (pre == curMin) {
                head = head.next;
            }
        }
        return dummy.next;
    }
}


//Given a singly-linked list, where each node contains an integer value, sort it in 
//ascending order. The merge sort algorithm should be used to solve this problem.
//
//Examples
//
//null, is sorted to null
//1 -> null, is sorted to 1 -> null
//1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6

public class MergeSortLinkedList {

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddleNode(head);
        ListNode secondHead = middle.next;
        middle.next = null;
        head = mergeSort(head);
        secondHead = mergeSort(secondHead);
        return merge(head, secondHead);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
    
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


import java.util.ArrayList;
import java.util.List;

//Given a set of characters represented by a String, return a list containing all 
//subsets of the characters. 
//
//Assumptions
//There are no duplicate characters in the original set.
//
//Examples
//Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//Set = "", all the subsets are [""]
//Set = null, all the subsets are []

public class AllSubsetsI {

    //                          root(abc)
    //                      /           \
    //L0(a):            [a]                 []
    //              /       \             /     \
    //L1(b):    [a,b]       [a]         [b]     []
    //          /   \       /   \       / \     / \
    //L2(c):[a,b,c] [a,b] [a,c] [a] [b,c] [b] [c] []
    
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        helper(result, set.toCharArray(), new StringBuilder(), 0);
        return result;
    }
    
    private void helper(List<String> result, char[] arraySet, StringBuilder sb, int index) {
        if (index == arraySet.length) {
            result.add(sb.toString());
            return;
        }
        // add current char to path
        sb.append(arraySet[index]);
        helper(result, arraySet, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        // do not add current char to path
        helper(result, arraySet, sb, index + 1);
    }
}



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of characters represented by a String, return a list containing all 
//subsets of the characters.
//
//Assumptions
//There could be duplicate characters in the original set.
//
//Examples
//Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
//Set = "", all the subsets are [""]
//Set = null, all the subsets are []

public class AllSubSetsII {

    //                              root(abb)
    //                          /               \
    //L0(a)                a(bb)                  (abb)
    //                  /       \               /       \
    //L1(b)         ab(b)       a(bb)          b(b)     (bb)
    //            /     \       /   \         / \       /   \
    //L2(b)   abb()     ab()    X   a(bb)   bb  b(b)   X    ()
    
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arr = set.toCharArray();
        Arrays.sort(arr);
        helper(result, arr, new StringBuilder(), 0);
        return result;
    }
    
    private void helper(List<String> result, char[] arr, StringBuilder sb, int index) {
        if (index == arr.length) {
            result.add(sb.toString());
            return;
        }
        // add current char to path
        sb.append(arr[index]);
        helper(result, arr, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        // skip all duplicate chars
        while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        // do not add current char to path
        helper(result, arr, sb, index + 1);
    }
}


import java.util.ArrayList;
import java.util.List;

//Given a string with no duplicate characters, return a list with all permutations of 
//the characters.
//
//Examples
//Set = "abc", all permutations are ["abc", "acb", "bac", "bca", "cab", "cba"]
//Set = "", all permutations are [""]
//Set = null, all permutations are []

public class AllPermutationsI {

    //                              root=abc
    //                      /           |           \
    //L0(p0):           a(bc)           b(ac)           c(ab)
    //                  /   \           /   \           /   \
    //L1(p1):       ab(c)   ac(b)   ba(c)   bc(a)   ca(b)   cb(a)
    //              |       |       |       |       |       |
    //L2(p2):       abc     acb     bac     bca     cab     cba

    // Method 1
//  public List<String> permutations(String set) {
//      List<String> result = new ArrayList<>();
//      if (set == null) {
//          return result;
//      }
//      char[] arraySet = set.toCharArray();
//      boolean[] visited = new boolean[arraySet.length];
//      helper(result, arraySet, visited, new StringBuilder());
//      return result;
//  }
//
//  private void helper(List<String> result, char[] arraySet, boolean[] visited, StringBuilder sb) {
//      if (sb.length() == arraySet.length) {
//          result.add(sb.toString());
//          return;
//      }
//      for (int i = 0; i < arraySet.length; i++) {
//          if (!visited[i]) {
//              visited[i] = true;
//              sb.append(arraySet[i]);
//              helper(result, arraySet, visited, sb);
//              visited[i] = false;
//              sb.deleteCharAt(sb.length() - 1);
//          }
//      }
//  }
    
    // Method 2
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        helper(result, arraySet, 0);
        return result;
    }
    
    private void helper(List<String> result, char[] arraySet, int index) {
        if (index == arraySet.length) {
            result.add(new String(arraySet));
            return;
        }
        for (int i = index; i < arraySet.length; i++) {
            swap(arraySet, index, i);
            helper(result, arraySet, index + 1);
            swap(arraySet, index, i);
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a string with possible duplicate characters, return a list with all permutations 
//of the characters.
//
//Examples
//Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//Set = "aba", all permutations are ["aab", "aba", "baa"]
//Set = "", all permutations are [""]
//Set = null, all permutations are []

public class AllPermutationsII {

    //                  root(aba)
    //              /       |       \
    //      a(ba)           b(aa)       a(ab)(cut)
    //      /   \           /   \       
    //  ab(a)   aa(b)   ba(a)   ba(a)(cut)
    //  |       |
    //  aba     aab
    
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        helper(result, set.toCharArray(), 0);
        return result;
    }
    
    private void helper(List<String> result, char[] arr, int index) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        Set<Character> visited = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!visited.contains(arr[i])) {
                visited.add(arr[i]);
                swap(arr, index, i);
                helper(result, arr, index + 1);
                swap(arr, index, i);
            }
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


import java.util.ArrayList;
import java.util.List;

//Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 
//25 cents), get all the possible ways to pay a target number of cents.
//
//Arguments
//coins - an array of positive integers representing the different denominations of coins, 
//there are no duplicate numbers and the numbers are sorted by descending order, 
//e.g. {25, 10, 5, 2, 1}
//target - a non-negative integer representing the target number of cents, e.g. 99
//
//Assumptions
//coins is not null and is not empty, all the numbers in coins are positive
//target >= 0
//You have infinite number of coins for each of the denominations, you can pick any 
//number of the coins.
//
//Return
//a list of ways of combinations of coins to sum up to be target.
//each way of combinations is represented by list of integer, the number at each index 
//means the number of coins used for the denomination at corresponding index.
//
//Examples
//coins = {2, 1}, target = 4, the return should be
//[
//  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
//  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
//  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
//]

public class CombinationsOfCoins {

    //                                  root(rem=4)
    //                          /               |       \
    //L0(2):        0*2(rem=4)              1*2(rem=2)      2*2(rem=0)
    //              /   |   |||     \
    //L1(1):0*1(rem=4)  1*1(rem=3)...4*1(rem=0)
    
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        if (target < 0 || coins == null || coins.length == 0) {
            return result;
        }
        helper(result, target, coins, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int target, int[] coins, List<Integer> curr, int index) {
        // if index already points to the last coin, we can immediately check
        // the result of next level in the current level
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                curr.add(target / coins[index]);
                result.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= target / coins[index]; i++) {
            curr.add(i);
            helper(result, target - i * coins[index], coins, curr, index + 1);
            curr.remove(curr.size() - 1);
        }
    }
}




import java.util.ArrayList;
import java.util.List;

//Given N pairs of parentheses "()", return a list with all the valid permutations.
//
//Assumptions
//N >= 0
//
//Examples
//N = 1, all valid permutations are ["()"]
//N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
//N = 0, all valid permutations are [""]

public class AllValidPermutationsOfParenthesesI {

    //                                  root
    //                              /           \
    //L0(p0):                   [(]             [)](kill)
    //                      /       \
    //L1(p1):           [((]            [()]    
    //              /       \           /   \
    //L2(p2):   [(((]       [(()]   [()(]   [())](kill)
    //          /       \
    //L3(p3):[((((](kill)[((()]
    //
    //L4(p4):   ...
    //
    //L5(p5):   ...
    
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        helper(result, new StringBuilder(), n, n);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            helper(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(")");
            helper(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
//
//Assumptions
//l, m, n >= 0
//
//Examples
//l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]

public class AllValidPermutationsOfParenthesesII {
    
    private final static char[] chars = { '(', ')', '[', ']', '{', '}' };

    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        if (l < 0 || m < 0 || n < 0) {
            return result;
        }
        int targetLength = l * 2 + m * 2 + n * 2;
        int[][] pairs = new int[][] { { l, l }, { m, m }, { n, n } };
        helper(result, new ArrayDeque<Character>(), new StringBuilder(), targetLength, pairs);
        return result;
    }
    
    private void helper(List<String> result, Deque<Character> stack, StringBuilder sb, int targetLength, int[][] pairs) {
        if (sb.length() == targetLength) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < pairs.length * 2; i++) {
            int[] pair = pairs[i / 2];
            if (i % 2 == 0) {
                if (pair[0] > 0) {
                    stack.push(chars[i]);
                    sb.append(chars[i]);
                    pair[0]--;
                    helper(result, stack, sb, targetLength, pairs);
                    pair[0]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty() && stack.peek() == chars[i - 1] && pair[1] > pair[0]) {
                    stack.pop();
                    sb.append(chars[i]);
                    pair[1]--;
                    helper(result, stack, sb, targetLength, pairs);
                    pair[1]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push(chars[i - 1]);
                }
            }
        }
    }
}


public class MergeSort {
    
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        // copy content to helper array and merge from it
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        // copy rest of the left part
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
        // no need to copy rest of the right part because they are already in
        // place
    }
}



public class SelectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            int local = i;
            // Look for local min
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[local]) {
                    local = j;  // update local min index
                }
            }
            if (local != i) {
                swap(array, local, i);
            }
        }
        return array;
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}



import java.util.PriorityQueue;

//Given a matrix of size N x M. For each row the elements are sorted in ascending order, 
//and for each column the elements are also sorted in ascending order. Find the Kth 
//smallest number in it.
//
//Assumptions
//the matrix is not null, N > 0 and M > 0
//K > 0 and K <= N * M
//
//Examples
//{ {1,  3,  5,  7},
//  {2,  4,  8,  9},
//  {3,  5, 11, 15},
//  {6,  8, 13, 18} }
//
//the 5th smallest number is 4
//the 8th smallest number is 6

public class KthSmallestNumberInSortedMatrix {

    // 1 3 5
    // 2 4 6

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k <= 0) {
            return -1;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
        minHeap.offer(new Cell(matrix[0][0], 0, 0));
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            if (curr.col + 1 < colCount && !visited[curr.row][curr.col + 1]) {
                minHeap.offer(new Cell(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
                visited[curr.row][curr.col + 1] = true;
            }
            if (curr.row + 1 < rowCount && !visited[curr.row + 1][curr.col]) {
                minHeap.offer(new Cell(matrix[curr.row + 1][curr.col], curr.row + 1, curr.col));
                visited[curr.row + 1][curr.col] = true;
            }
        }
        return minHeap.peek().val;
    }

    class Cell implements Comparable<Cell> {
        int val;
        int row;
        int col;

        Cell(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        
        @Override
        public int compareTo(Cell another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;
        }
    }
}


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, 
//where a is one element from A and b is one element from B. Find the Kth smallest s out 
//of all possible s'.
//
//Assumptions
//A is not null and A is not of zero length, so as B
//K > 0 and K <= m * n
//
//Examples
//A = {1, 3, 5}, B = {4, 8}
//
//1st smallest s is 1 + 4 = 5
//2nd smallest s is 3 + 4 = 7
//3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
//5th smallest s is 3 + 8 = 11

public class KthSmallestSumInTwoSortedArray {

    //    1 3 5
    //-----------
    // 4| 
    // 8|
    public int kthSum(int[] A, int[] B, int k) {
        int rows = A.length;
        int cols = B.length;
        Queue<Sum> minHeap = new PriorityQueue<>(k, new Comparator<Sum>() {
            @Override
            public int compare(Sum s1, Sum s2) {
                return Integer.compare(s1.val, s2.val);
            }
        });
        minHeap.offer(new Sum(0, 0, A[0] + B[0]));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        int[] row = { 1, 0 };
        int[] col = { 0, 1 };
        for (int i = 0; i < k - 1; i++) {
            Sum cur = minHeap.poll();
            for (int j = 0; j < row.length; j++) {
                int newRow = cur.row + row[j];
                int newCol = cur.col + col[j];
                if (newRow < rows && newCol < cols && !visited[newRow][newCol]) {
                    minHeap.offer(new Sum(newRow, newCol, A[newRow] + B[newCol]));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return minHeap.peek().val;
    }
    
    class Sum {
        int row;
        int col;
        int val;
        
        Sum(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}


