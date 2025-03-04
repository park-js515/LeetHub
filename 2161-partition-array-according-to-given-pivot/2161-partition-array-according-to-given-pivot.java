import java.util.ArrayList;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                list1.add(num);
            } else if (num == pivot) {
                list2.add(num);
            } else {
                list3.add(num);
            }
        }

        list1.addAll(list2);
        list1.addAll(list3);

        return list1.stream().mapToInt(Integer::intValue).toArray();
    }
}