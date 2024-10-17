class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int pos = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos;
    }
}


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null) {
            return -1;
        }

        int max = 0;
        for (int num: piles) {
            max = Math.max(max, num);
        }

        int left = 1;
        int right = max;
        int k = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int num: piles) {
                // hours += Math.ceil(num / mid);
                hours += num / mid;
                if (num % mid != 0) {
                    hours += 1;
                }
            }

            if (hours <= h) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two 
nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && root.val <= q.val || q.val <= root.val && root.val <= p.val) {
            return root;
        }

        if (p.val < q.val && q.val < root.val || q.val < p.val && p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > q.val && q.val > root.val || q.val > p.val && p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }
}

/*
def sink_data():
    batch_size = 10000
    create_date = 'xxx'
    batch_start_pid = 0

    sql_1 = f"SELECT MAX(pid) FROM TEAM_REPORT_HISOTRY WHERE create_date = '{create_date}'"
    sql_2 = f"SELECT MIN(pid) FROM TEAM_REPORT_HISOTRY WHERE create_date = '{create_date}' AND pid >= {batch_start_pid}"
    sql_3 = f"SELECT * FROM TEAM_REPORT_HISTORY WHERE pid >= {start_id} AND pid < {end_id} ORDER BY create_date ASC, pid ASC"

    max_pid = query(sql_1)
    total_rows = []

    while True:
        batch_start_pid = query(sql_2)

        if batch_start_pid > max_pid:
            break

        while True:
            batch_rows = batch_query(batch_start_pid, batch_start_pid + batch_size, sql_3)
            idx = binary_search(batch_rows, create_date)
            total_rows.extend(batch_rows[0:idx])
            if idx < len(batch_rows):
                batch_start_pid = batch_rows[idx - 1]['pid'] + 1    # Must have a pid ASC order, very important!
                break
            batch_start_pid += batch_size

    return total_rows

# Ref Leetcode 278 "first bad version"
def binary_search(rows, create_date):
    left = 0
    right = len(rows) - 1
    pos = len(rows)

    while left <= right:
        mid = left + (right - left) / 2
        if rows[mid]['create_date'] != create_date:
            pos = mid
            right = mid - 1
        else:
            left = mid + 1
    return pos
*/



'''
https://dev.mysql.com/doc/connector-python/en/connector-python-api-mysqlcursor-stored-results.html
https://dev.mysql.com/doc/refman/8.0/en/gone-away.html
https://docs.google.com/spreadsheets/d/1Kh1OsJW4_Cf7SEthlvNHv6KE5_6mWoT13mNOeojBSuU/edit#gid=1399042927 

https://www.teamblind.com/post/System-Design-Interview-Prep-[FBGoogle]-hDAHr8Zx
https://www.teamblind.com/post/my-interview-prep-guide-for-google-l5--fb-e6-E4NXiL33
https://github.com/donnemartin/system-design-primer#study-guide
https://www.youtube.com/c/SystemDesignInterview

scott shi youtube
https://hiretual.zoom.us/j/94784683147
https://docs.npmjs.com/about-semantic-versioning





"""

"""
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[3];
        helper(arr, root, k);
        return arr[0];
    }

    private void helper(int[] arr, TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (arr[2] == 1) {
            return;
        }
        helper(arr, node.left, k);
        if (arr[1]++ == k - 1) {
            arr[0] = node.val;
            arr[2] = 1;
        }
        helper(arr, node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }


if (x - A[mid] > A[mid + k] - x)

Given a sorted array, two integers k and x, find the k closest elements to x in the array.
The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
UPDATE (2017/9/19):
The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.

/**
0            2n-2            4n-4
1    2n-3    2n-1    4n-5    4n-3
2    2n-4    2n      4n-6    4n-2
3    2n-5    2n+1    4n-7    4n-1
...  ...     ...     ...     ...
k    2n-k-2  2n+k-2  4n-k-4  4n+k-4
...  ...     ...     ...     ...
n-4  n+2     3n-6    3n      5n-8
n-3  n+1     3n-5    3n-1    5n-7
n-2  n       3n-4    3n-2    5n-6
n-1          3n-3            5n-5

x - k + 1 = (n - 1 - k + 1) + (n - 1 - k + 1 - 1)
      = n - k + n - k - 1
      = 2n - 2k - 1
=>
x = 2n - k - 2

odd  row: 
oven row:

    public String convert(String s, int numRows) {
        int n = numRows;
        StringBuilder[] map = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            map[i] = new StringBuilder();
        }
        int col = 0;
        while (true) {
            boolean isBreak = false;
            int start = (col / 2) * (2 * n - 2);
            for (int i = 0; i < n; i++) {
                int j = start + i;
                if (j >= s.length()) {
                    isBreak = true;
                    break;
                }
                map[i].append(s.charAt(j));
            }
            if (isBreak) {
                break;
            }
            col++;
            for (int i = n - 2; i >= 1; i--) {
                int j = start + 2 * n - i - 2;
                if (j >= s.length()) {
                    isBreak = true;
                    break;
                }
                map[i].append(s.charAt(j));
            }
            if (isBreak) {
                break;
            }
            col++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]);
        }
        return sb.toString();
    }

    /**
     * Notes:
     *     1.
     *
     * Problem Analysis:
     *     1. Assume dis(i) = abs(arr[i] - x) if the distance from element arr[i] to point x,
     *        then disSum(i) = dis(i) + dis(i + 1) +...+ dis(i + k), the solution is to find
     *        first occurence of `pos` such that disSum(pos) has smallest value.
     *     2. Use O(n) time algorithm to traverse this array is a trivial solution.
     *
     * General Cases:
     *     1. i <  k - 1; ---> // do nothing
     *     2. i >= k - 1; ---> compare sum and pos, subtract dis(i - k + 1)
     *
     * Time:  O(n)
     * Space: O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int sum = 0;
        int pos = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i] - x);
            if (i >= k - 1) {
                if (sum < min) {
                    pos = i - k + 1;
                    min = sum;
                }
                sum -= Math.abs(arr[i - k + 1] - x);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = pos; i < start + k; i++) {
            result.add(arr[i]);
        }
        return Arrays.stream(arr, pos, pos + k).boxed().collect(Collectors.toList());
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.poll();
            }
            deque.offer(i);
            if (i > k - 1) {
                result[i - k + 1]
            }
        }
    }


Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k < 1 || k >= nums.length) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; result.size() < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            int remainedSize = k - result.size();
            if (bucket[i].size() < remainedSize) {
                result.addAll(bucket[i]);
                continue;
            }

            for (int j = 0; j < remainedSize; j++) {
                result.add(bucket[i].get(j));
            }
        }
        
        int[] resultArray = new int[k];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        
    }
}
0 + 012 = 012
3 + 012 = 345
6 + 012 = 678

3 * (i / 3) + j / 3
3 * (i % 3) + j % 3

00 01 02 
10 11 12
20 21 22 
30 31 32 33 34 35
40 41 42 43 44 45
50 51 52 53 54 55



f(x) < target

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos + 1;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }

        int left = 1;
        int right = n;
        int pos = n + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return pos;
    }
}
'''