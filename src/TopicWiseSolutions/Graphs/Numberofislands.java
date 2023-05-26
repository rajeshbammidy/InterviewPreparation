package TopicWiseSolutions.Graphs;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|Numberofislands| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class Numberofislands {
    static class node {
        int x;
        int y;


        node(int i, int j) {
            x = i;
            y = j;

        }
    }

    public int solve(ArrayList<ArrayList<Integer>> list) {


        ArrayList<node> inp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {

                if (list.get(i).get(j) == 1)
                    inp.add(new node(i, j));
            }

        }
        int ans = 0;
        for (int i = 0; i < inp.size(); i++) {
            node temp = inp.get(i);
            int x = temp.x;
            int y = temp.y;
            if (list.get(x).get(y) == 1) {
                bfs(list, temp);
                ans++;
            }
        }
        return ans;
    }

    private void bfs(ArrayList<ArrayList<Integer>> list, node temp) {
        Queue<node> queue = new LinkedList<>();
        int m = list.size() - 1;
        int n = list.get(0).size() - 1;
        queue.add(temp);
        HashSet<String> set = new HashSet<>();
        set.add(temp.x + "-" + temp.y);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            int xx = temp.x;
            int yy = temp.y;

            list.get(xx).set(yy, 0);

            //right
            if (isValid(temp.x, temp.y + 1, m, n)) {
                int x = temp.x;
                int y = temp.y + 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check left
            if (isValid(temp.x, temp.y - 1, m, n)) {
                int x = temp.x;
                int y = temp.y - 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check down
            if (isValid(temp.x + 1, temp.y, m, n)) {
                int x = temp.x + 1;
                int y = temp.y;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check up
            if (isValid(temp.x - 1, temp.y, m, n)) {
                int x = temp.x - 1;
                int y = temp.y;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check left dia
            if (isValid(temp.x - 1, temp.y - 1, m, n)) {
                int x = temp.x - 1;
                int y = temp.y - 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check right dia

            if (isValid(temp.x - 1, temp.y + 1, m, n)) {
                int x = temp.x - 1;
                int y = temp.y + 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check lower left dia
            if (isValid(temp.x + 1, temp.y - 1, m, n)) {
                int x = temp.x + 1;
                int y = temp.y - 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }

            //check lower right dia
            if (isValid(temp.x + 1, temp.y + 1, m, n)) {
                int x = temp.x + 1;
                int y = temp.y + 1;
                if (list.get(x).get(y) == 1 && !set.contains(x + "-" + y)) {
                    set.add(x + "-" + y);
                    queue.add(new node(x, y));
                }
            }


        }
    }


    private boolean isValid(int x, int y, int m, int n) {

        return (x >= 0 && x <= m) && (y >= 0 && y <= n);
    }
}
