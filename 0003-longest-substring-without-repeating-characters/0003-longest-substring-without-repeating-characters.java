import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int answer = 0;
        int cnt = 0;
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                int before = map.get(ch);
                answer = Math.max(answer, cnt);
                map.entrySet().removeIf(entry -> entry.getValue() < before);
                cnt = i - before - 1;
            }
            map.put(ch, i);
            cnt++;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : map.values()) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        answer = Math.max(answer, max - min + 1);

        return answer;
    }
}