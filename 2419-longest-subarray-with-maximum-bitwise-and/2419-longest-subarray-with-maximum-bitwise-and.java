class Solution {    
    public int longestSubarray(int[] nums) {
        int answerTarget = 0;
        int answer = 0;
        int target = nums[0];
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                cnt++;
            } else {
                if (answerTarget < target) {
                    answer = cnt;
                    answerTarget = target;
                } else if (answerTarget == target) {
                    answer = Math.max(answer, cnt);
                }
                target = nums[i];
                cnt = 1;
            }
        }

        if (answerTarget < target) {
            answer = cnt;
        }

        return answer;
    }
}