class Solution {
    private final char white = 'W';
    private final char black = 'B';

    public int minimumRecolors(String blocks, int k) {
        int answer = Integer.MAX_VALUE;
        int len = blocks.length();
        int left, right;
        int temp = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == white) {
                temp++;
            }
        }

        answer = Math.min(answer, temp);

        left = 0;
        right = k - 1;
        while (right < len - 1) {
            temp -= blocks.charAt(left++) == white ? 1 : 0;
            temp += blocks.charAt(++right) == white ? 1 : 0;
            answer = Math.min(answer, temp);
        }


        return answer;
    }
}