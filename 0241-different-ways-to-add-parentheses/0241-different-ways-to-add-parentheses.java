import java.util.*;

// matrix[from][to] = calc(matrix[from][i], matrix[i + 1][to], op.get(i)), where from <= i < to
// use memoization for optimization
class Solution {
    private int len;
    private List<Integer>[][] matrix;
    private boolean[][] visited;
    private List<Integer> nums = new ArrayList<>();
    private List<Character> op = new ArrayList<>();

    private int calc(int num1, int num2, char operation) {
        if (operation == '+') {
            return num1 + num2;
        } else if (operation == '-') {
            return num1 - num2;
        }
        return num1 * num2;
    }

    private void init(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                nums.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                op.add(ch);
            }
        }
        nums.add(Integer.parseInt(sb.toString()));

        this.len = nums.size();
        this.matrix = new ArrayList[len][len];
        this.visited = new boolean[len][len];
    }

    private void dfs(int from, int to) {
        List<Integer> list = new ArrayList<>();

        if (from == to) {
            visited[from][to] = true;
            list.add(nums.get(from));
            matrix[from][to] = list;
            return;
        }
        
        for (int i = from; i < to; i++) {
            if (!visited[from][i]) dfs(from, i);
            if (!visited[i + 1][to]) dfs(i + 1, to);

            List<Integer> l1 = matrix[from][i];
            List<Integer> l2 = matrix[i + 1][to];
            for (int n1 : l1) {
                for (int n2 : l2) {
                    list.add(calc(n1, n2, op.get(i)));
                }
            }
        }

        visited[from][to] = true;
        matrix[from][to] = list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        init(expression);
        dfs(0, len - 1);

        return matrix[0][len - 1];
    }
}