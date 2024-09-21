class Solution {
    private int n;
    private int len;
    private List<Integer> answer = new ArrayList<>();

    private void init(int n) {
        this.n = n;

        int temp = n;
        int len = 0;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        this.len = len;
    }

    private void dfs(int depth, int num) {
        if (num <= n) {
            answer.add(num);
        } else {
            return;
        }

        if (depth == len) { return; }

        for (int i = 0; i <= 9; i++) {
            dfs(depth + 1, num * 10 + i);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        init(n);
        for (int i = 1; i <= 9; i++) {
            dfs(1, i);
        }

        return answer;
    }
}