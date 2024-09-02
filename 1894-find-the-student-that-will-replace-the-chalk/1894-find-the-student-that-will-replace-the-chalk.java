class Solution {
    private int setK(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }

        return (int) (k % sum);
    }

    public int chalkReplacer(int[] chalk, int k) {
        k = setK(chalk, k);
        int answer = 0;
        int len = chalk.length;
        int index = 0;

        while (true) {
            if (k < chalk[index]) {
                answer = index;
                break;
            }

            k -= chalk[index];
            index++;
            index %= len;
        }

        return answer;
    }
}