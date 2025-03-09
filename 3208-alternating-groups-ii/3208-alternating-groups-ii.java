class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] diff = new int[n]; // dismatch : 0, match : 1;
        
        for (int i = 0; i < n - 1; i++) {
            diff[i] = colors[i] != colors[i + 1] ? 0 : 1;
        }
        diff[n - 1] = colors[n - 1] != colors[0] ? 0 : 1;

        int sum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += diff[i];
        }

        int answer = sum == 0 ? 1 : 0;        
        int left = 0;
        int right = k - 1;
        
        for (int i = 1; i < n; i++) {
            sum -= diff[left];
            sum += diff[right];
            
            left = (left + 1) % n;
            right = (right + 1) % n;
            
            answer += sum == 0 ? 1 : 0;
        }

        return answer;
    }
}