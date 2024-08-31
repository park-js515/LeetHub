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

import java.util.ArrayDeque;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag1 = true, flag2 = true;
        int over = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        while (flag1 || flag2) {
            int n1 = 0, n2 = 0;
            if (flag1) {
                n1 = l1.val;
                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    flag1 = false;
                }
            }

            if (flag2) {
                n2 = l2.val;
                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    flag2 = false;
                }
            }

            int num = n1 + n2 + over;
            over = num / 10;
            num %= 10;
            stack.add(num);
        }

        while (over > 0) {
            stack.add(over % 10);
            over /= 10;
        }

        ListNode answer = null;
        while (!stack.isEmpty()) {
            answer = new ListNode(stack.pollLast(), answer);
        }

        return answer;
    }
}