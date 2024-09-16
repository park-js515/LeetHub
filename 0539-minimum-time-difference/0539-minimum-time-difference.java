import java.util.*;

class Solution {
    private int timeToInt(String timePoint) {
        String[] split = timePoint.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        return h * 60 + m;
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String timePoint : timePoints) {
            list.add(timeToInt(timePoint));
        }
        Collections.sort(list);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int gap = list.get(i) - list.get(i - 1);
            gap = Math.min(gap, 1440 - gap);
            answer = Math.min(answer, gap);
        }

        // consider cycle
        int gap = list.get(list.size() - 1) - list.get(0);
        gap = Math.min(gap, 1440 - gap);
        answer = Math.min(answer, gap);

        return answer;
    }
}