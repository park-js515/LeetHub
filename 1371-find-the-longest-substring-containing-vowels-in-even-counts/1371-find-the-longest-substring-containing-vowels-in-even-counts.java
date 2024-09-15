import java.util.*;

class Solution {
    private Map<Character, Integer> map;
    private Set<Character> vowel;
    private int len;
    private int[] bitMask;

    private void init(String s) {
        this.map = Map.of(
            'a', 0,
            'e', 1,
            'i', 2,
            'o', 3,
            'u', 4
        );

        this.vowel = new HashSet<>(map.keySet());
        this.len = s.length();

        this.bitMask = new int[len];
        if (vowel.contains(s.charAt(0))) {
            bitMask[0] = 1 << map.get(s.charAt(0));
        }
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            bitMask[i] = bitMask[i - 1];
            if (vowel.contains(ch)) {
                int move = map.get(ch);
                bitMask[i] ^= (1 << move);
            }
        }
    }
    
    // bitMask[i] == 0 => s.substring(0, i + 1) : satisfy
    // bitMask[i] == bitMask[j] => s.subString(i + 1, j + 1) : satisfy
    public int findTheLongestSubstring(String s) {
        init(s);

        // System.out.println(Arrays.toString(bitMask));

        // find min, max index
        int[][] matrix = new int[32][2];
        for (int i = 0; i < 32; i++) {
            matrix[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            int target = bitMask[i];
            matrix[target][0] = Math.min(matrix[target][0], i);
            matrix[target][1] = Math.max(matrix[target][1], i);
        }

        int answer = 0;
        if (matrix[0][0] != Integer.MAX_VALUE) {
            answer = matrix[0][1] + 1;
        }
        for (int i = 1; i < 32; i++) {
            if (matrix[i][0] == Integer.MAX_VALUE) continue;
            answer = Math.max(answer, matrix[i][1] - matrix[i][0]);
        }

        return answer;
    }
}