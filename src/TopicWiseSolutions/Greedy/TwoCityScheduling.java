package TopicWiseSolutions.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Greedy|TwoCityScheduling| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class TwoCityScheduling {
    static class node {
        int x;
        int y;
        int z;

        public node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        ArrayList<node> list = new ArrayList<>();

        for (int i = 0; i < costs.length; i++) {
            list.add(new node(costs[i][0], costs[i][1], costs[i][1] - costs[i][0]));
        }
        list.sort(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return -(o1.z - o2.z);
            }
        });
        int n = costs.length;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += list.get(i).x;
        }
        for (int i = n / 2; i < n; i++) {
            ans += list.get(i).y;
        }
        return ans;
    }
}
