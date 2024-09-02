class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int left = 0;
        int right = 0;
        int index = 0;

        while (left < len1 && right < len2) {
            if (nums1[left] < nums2[right]) {
                nums[index++] = nums1[left++];
            } else {
                nums[index++] = nums2[right++];
            }
        }

        while (left < len1) {
            nums[index++] = nums1[left++];
        }
        while (right < len2) {
            nums[index++] = nums2[right++];
        }

        double answer = 0;
        int half = (len1 + len2) / 2;
        if ((len1 + len2) % 2 == 0) {
            answer = ((double) nums[half - 1] + nums[half]) / 2;
        } else {
            answer = nums[half];
        }

        return answer;
    }
}