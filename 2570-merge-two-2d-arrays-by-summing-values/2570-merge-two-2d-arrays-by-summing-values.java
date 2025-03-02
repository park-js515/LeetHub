import java.util.ArrayList;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] arr = new int[1001];

        for (int[] nums : nums1) {
            arr[nums[0]] += nums[1];
        }

        for (int[] nums : nums2) {
            arr[nums[0]] += nums[1];
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (arr[i] != 0) {
                list.add(new int[] {i, arr[i]});
            }
        }

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}