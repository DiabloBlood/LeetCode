


public class Solution160 {
    /**
     * Problem Analysis:
     *     1. Assume list A length is `m`, list B length is `n`.
     *     2. Index of both head is `1`, index of `null` is `m + 1` and `n + 1`, respectively.
     *     3. Assume intersection index at list A is `x`, at list B is `y`.
     *     4. If `x == y`, ptr `curA` route is `a[1] ~ a[x]`, ptr `curB` route is `b[1] ~ b[y]`, same steps.
     *     4. If `x != y`, ptr `curA` route is  `a[1] ~ a[x] ~ a[m+1] ~ b[1] ~ b[y]`, ptr `curB` route is `b[1] ~ b[y] ~ b[n+1] ~ a[1] ~ a[x]`,
     *        ptr `curA` walk `x-1 + m+1-x + 1 + y-1` steps, ptr `curB` walk `y-1 + n+1-y + 1 + x-1` steps.
     *     5. Since `m+1-x == n+1-y`, assume this distance is `C`,
     *        then ptr `curA` walk `x-1 + C + 1 + y-1` steps, ptr `curB` walk `y-1 + C + 1 + x-1` steps, the number of steps is same.
     *     6. if list A and list B don't have intersection,
     *        `curA` route is `a[1] ~ a[m+1] ~ b[1] ~ b[n+1]`, `curB` route is `b[1] ~ b[n+1] ~ a[1] ~ a[m+1]`,
     *        `curA` walk `m + 1 + n` steps, `curB` walk `n + 1 + m` steps.
     *
     * Corner Cases:
     *     1. headA == null && headB == null; ---> doesn't need to handle, return value `curA` is `null`.
     *     2. headA == null && headB != null;
     *            ---> Finally, `curA` at `tailB.next == null`, `curB` at `headA == null`, return value is `null`.
     *     3. headA != null && headB == null;
     *            ---> Finally, `curA` at  `headB == null`, `curB` at `tailA.next == null`, return value is `null`.
     *     4. list A and list B don't have intersection.
     *            ---> Finally, `curA` at `tailB.next == null`, `curB` at `tailA.next == null`, return value is `null`.
     *     5. x == y; ---> `curA` will return before arrive `null`.
     *
     * Time:  O(m + n), best is O(1), general case `curA` and `curB` will walk all nodes of list A and list B, time is O(m + n)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
