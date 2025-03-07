class Solution {
    private final int MAX = 1_000_000;
    private List<Integer> satisfied = new ArrayList<>();

    private void findPrime(int left, int right) {
        boolean[] isNotPrime = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                if (left <= i && i <= right) {
                    satisfied.add(i);
                }
                for (int j = i * 2; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int[] answer = {-1, -1};
        findPrime(left, right);

        if (satisfied.size() < 2) {
            return answer;
        }

        answer = new int[] {satisfied.get(0), satisfied.get(1)};
        int gap = answer[1] - answer[0];

        for (int i = 1; i < satisfied.size() - 1; i++) {
            int num1 = satisfied.get(i);
            int num2 = satisfied.get(i + 1);
            if (num2 - num1 < gap) {
                gap = num2 - num1;
                answer = new int[] {num1, num2};
            }
        }

        return answer;
    }
}