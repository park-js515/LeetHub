class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty() || !map.containsKey(stack.peekLast()) || map.get(stack.peekLast()) != ch) {
                stack.add(ch);
            } else {
                stack.pollLast();
            }
        }

        while (stack.size() >= 2) {
            char a = stack.poll();
            char b = stack.poll();

            if (!map.containsKey(a) || b != map.get(a)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}