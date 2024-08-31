import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        int left = 0;
        int right = 0;
        point: for (int i : map.keySet()) {
            int gap = target - i;
            List<Integer> list = map.get(i);

            if (i == gap) {
                if (map.get(i).size() == 2) {
                    left = map.get(i).get(0);
                    right = map.get(i).get(1);
                    break point;
                }
            } else {
                if (map.containsKey(gap)) {
                    left = map.get(i).get(0);
                    right = map.get(gap).get(0);
                    break point;
                }
            }
        }

        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        return new int[] {left, right};
    }
    
}