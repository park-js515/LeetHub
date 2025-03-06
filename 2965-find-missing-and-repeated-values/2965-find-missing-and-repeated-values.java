class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] visited = new int[n * n + 1];
        int[] answer = new int[2];

        for (int[] row : grid) {
            for (int num : row) {
                visited[num]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (visited[i] == 0) {
                answer[1] = i;
            } else if (visited[i] == 2) {
                answer[0] = i;
            }
        }

        return answer;
    }
}