// https://prepfortech.io/leetcode-solutions/shortest-palindrome
// 실패 시: 뒷부분을 더해주어야 하며, 이를 재귀적으로 문제를 해결한다.
// 실패 시 하나의 문자를 더해주거나 뒷부분의 일정 더해주어야 한다.
public class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j); // diff
        System.out.println(suffix);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}