import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int answer = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            map.put(arr[j], j);

            for (int i = 0; i < j; i++) {
                int diff = arr[j] - arr[i];
                int prevIdx = map.getOrDefault(diff, -1);

                if (diff < arr[i] && prevIdx >= 0) {
                    dp[i][j] = dp[prevIdx][i] + 1;
                } else {
                    dp[i][j] = 2;
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer > 2 ? answer : 0;
    }
}