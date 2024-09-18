import java.util.*;

class Solution {
    private int getCompareValue(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len = Math.max(len1, len2) * 2;
        int ret = 0;
        
        for (int i = 0; i < len; i++) {
            int index1 = i % len1;
            int index2 = i % len2;
            char ch1 = s1.charAt(index1);
            char ch2 = s2.charAt(index2);
            if (ch1 != ch2) {
                ret = Character.compare(ch2, ch1);
                break;
            }
        }

        return ret;
    }

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, (o1, o2) -> getCompareValue(o1, o2));

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        String answer = sb.toString();
        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}