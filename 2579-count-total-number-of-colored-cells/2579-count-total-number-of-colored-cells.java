class Solution {
    public long coloredCells(int n) {
        long N = (long) n;
        long answer = (2 * N - 1) * (2 * N - 1);
        long sub = ((N - 1) * N) / 2L;
        answer -= 4 * sub;

        return answer;
    }
}