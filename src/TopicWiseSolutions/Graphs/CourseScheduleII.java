package TopicWiseSolutions.Graphs;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|CourseScheduleII| on Aug,2020
 *  
 * Happy Coding :)
 * 
 * 210. Course Schedule II
 **/

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] arr) {
        int m = arr.length;
        int res[] = new int[numCourses];
        if (m == 0) {

            for (int i = numCourses - 1; i >= 0; i--) {
                res[numCourses - i - 1] = i;

            }
            return res;

        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList());
        }

        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.get(arr[i][1]).add(arr[i][0]);
            }
        }
        int indeg[] = new int[numCourses];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indeg[arr[i][0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.add(i);
        }

        int c = 0;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            res[c++] = q;

            for (int x : list.get(q)) {
                indeg[x]--;
                if (indeg[x] == 0) queue.add(x);
            }

        }
        if (c == numCourses) return res;
        return new int[0];

    }
}
