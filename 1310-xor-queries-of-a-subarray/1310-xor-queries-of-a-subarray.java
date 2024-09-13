// a XOR a = 0

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len1 = arr.length;
        int len2 = queries.length;
        int[] dp  = new int[len1 + 1];
        for (int i = 0; i < len1; i++) {
            dp[i + 1] = dp[i] ^ arr[i];
        }

        int[] answer = new int[len2];
        for (int i = 0; i < len2; i++) {
            int[] query = queries[i];
            answer[i] = dp[query[1] + 1] ^ dp[query[0]];
        }
        
        return answer;
    }
}