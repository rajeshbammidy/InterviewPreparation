package Hashing;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|KClosestPointstoOrigin| on May,2020
 *  
 * Happy Coding :)
 **/
public class KClosestPointstoOrigin {
    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        TreeMap<Double, LinkedList<node>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            double sq = Math.sqrt((Math.abs(points[i][0]) * Math.abs(points[i][0])) + (Math.abs(points[i][1]) * Math.abs(points[i][1])));
            if (map.get(sq) == null) {
                LinkedList<node> list = new LinkedList<>();
                list.add(new node(points[i][0], points[i][1]));
                map.put(sq, list);
            } else {
                map.get(sq).add(new node(points[i][0], points[i][1]));
            }
        }
        int c = 0;
        int ans[][] = new int[k][2];
        for (Map.Entry<Double, LinkedList<node>> x : map.entrySet()) {

            for (node l : x.getValue()) {
                if (c >= k) {
                    return ans;
                }
                ans[c][0] = l.x;
                ans[c][1] = l.y;
                c++;
            }

        }
        return ans;
    }

}
