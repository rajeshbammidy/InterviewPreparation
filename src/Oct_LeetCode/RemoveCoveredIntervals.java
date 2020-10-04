package Oct_LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Oct_LeetCode|RemoveCoveredIntervals| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class RemoveCoveredIntervals {
    static class interval {
        int x;
        int y;

        public interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {
        ArrayList<interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new interval(intervals[i][0], intervals[i][1]));
        }
        list.sort(new Comparator<interval>() {
            @Override
            public int compare(interval o1, interval o2) {
                if(o1.x==o2.x){
                    return -o1.y-o2.y;
                }
                return o1.x - o2.x;
            }
        });
        Stack<interval> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(list.get(i));
                continue;
            }
            interval cur = list.get(i);

            if (stack.peek().x <= cur.x && stack.peek().y >= cur.y) {
                continue;
            }


            else stack.push(cur);
        }
        return stack.size();
    }
}
