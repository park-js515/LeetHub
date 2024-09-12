import java.util.*;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        point: for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) continue point;
            }
            answer++;
        }
        
        return answer;
    }
}