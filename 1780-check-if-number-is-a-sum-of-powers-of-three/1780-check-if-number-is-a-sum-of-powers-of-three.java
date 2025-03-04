class Solution {
    public boolean checkPowersOfThree(int n) {
        int k = 1;

        while (k <= n) {
            k *= 3;
        }

        while (k >= 1) {
            if (n >= k) {
                n -= k;
            }

            k /= 3;
        }

        return n == 0;
    }
}