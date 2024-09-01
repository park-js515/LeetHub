class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = "" + x;
        int left, right;
        boolean answer = true;

        if (s.length() % 2 == 0) {
            left = (s.length() / 2) - 1;
            right = left + 1;
        } else {
            left = right = s.length() / 2;
        }

        while (left >= 0) {
            if (s.charAt(left) != s.charAt(right)) {
                answer = false;
                break;
            }
            left--;
            right++;
        }

        return answer;
    }
}