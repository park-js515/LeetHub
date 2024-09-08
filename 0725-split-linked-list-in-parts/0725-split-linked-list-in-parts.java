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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }

        int size = queue.size();
        int q = size / k;
        for (int i = 0; i < k; i++) {
            int ad = q * k + i < size ? 1 : 0;
            ArrayDeque<Integer> innerQueue = new ArrayDeque<>();
            for (int j = 0; j < q + ad; j++) {
                innerQueue.add(queue.poll());
            }
            for(int j = 0; j < q + ad; j++) {
                listNodes[i] = new ListNode(innerQueue.pollLast(), listNodes[i]);
            }
        }

        return listNodes;
    }
}