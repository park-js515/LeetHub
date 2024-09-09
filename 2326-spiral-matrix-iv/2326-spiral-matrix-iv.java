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
    private int[][] d = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int total = m * n;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }

        int size = queue.size();
        for (int i = 0; i < total - size; i++) {
            queue.add(-1);
        }

        int r = 0;
        int c = 0;
        int direction = 0;
        point: while (!queue.isEmpty()) {
            answer[r][c] = queue.poll();
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nextDirection = (direction + i) % 4;
                int dr = r + d[nextDirection][0];
                int dc = c + d[nextDirection][1];

                if (dr < 0 || dr >= m || dc < 0 || dc >= n || visited[dr][dc]) continue;
                direction = nextDirection;
                r = dr;
                c = dc;
                continue point;
            }

            break point;
        }

        return answer;
    }
}