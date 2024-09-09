class Solution {
    private int len;

    private String getP(String s, int i, int j) {
        int left = i;
        int right = j;

        while (left >= 0 && right < len) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }

        return s.substring(left + 1, right);       
    }
    
    public String longestPalindrome(String s) {
        this.len = s.length();
        String answer = "";

        for (int i = 0; i < len; i++) {
            String s1 = getP(s, i, i);
            String s2 = getP(s, i, i + 1);
            if (answer.length() < s1.length()) {
                answer = s1;
            }
            if (answer.length() < s2.length()) {
                answer = s2;
            }
        }

        return answer;
    }
}