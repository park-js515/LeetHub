import java.util.*;

class MyCalendar {
    private static List<Pair> list;

    private static class Pair {
        int s, e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public MyCalendar() {
        this.list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        boolean result = true;

        for (Pair p : list) {
            if (p.s < end && start < p.e) {
                result = false;
                break;
            }

        }

        if (result) {
            list.add(new Pair(start, end));
        }

        return result;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */