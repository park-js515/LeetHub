class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char k : map.keySet()) {
            while (map.get(k) >= 3) {
                map.put(k, map.get(k) - 2);
            }
        }

        int answer = 0;
        for (int value : map.values()) {
            answer += value;
        }

        return answer;
    }
}