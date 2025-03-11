class Solution {
    private int getIndex(char ch) {
        return ch - 'a';
    }

    private boolean check(int[] cnt) {
        return cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0;
    }

    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int n = s.length();

        int left = 0, right = 0;
        int answer = 0;

        while (right < n) {
            cnt[getIndex(s.charAt(right))]++;

            while (check(cnt)) {
                answer += n - right;
                cnt[getIndex(s.charAt(left++))]--;
            }

            right++;
        }

        return answer;
    }
}