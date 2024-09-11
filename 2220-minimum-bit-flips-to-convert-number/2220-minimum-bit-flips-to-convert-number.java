class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toString(start, 2);
        String s2 = Integer.toString(goal, 2);
        
        int len = Math.max(s1.length(), s2.length());
        int gap1 = len - s1.length();
        int gap2 = len - s2.length();

        s1 = "0".repeat(gap1) + s1;
        s2 = "0".repeat(gap2) + s2;

        int answer = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) answer++;
        }

        return answer;
    }
}