/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.*;

class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }

        ListNode listNodes = new ListNode(deque.poll());
        while (!deque.isEmpty()) {
            int a = listNodes.val;
            int b = deque.poll();
            int gcd = gcd(a, b);
            listNodes = new ListNode(gcd, listNodes);
            listNodes = new ListNode(b, listNodes);
        }

        return listNodes;
    }
}