package TopicWiseSolutions.Graphs;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|Distanceofnearestcell| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class Distanceofnearestcell {
    static class node {
        int x;
        int y;
        boolean isDef = false;

        node(int i, int j, boolean isDef) {
            x = i;
            y = j;
            this.isDef = isDef;
        }
    }


    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> lis) {


        ArrayList<ArrayList<Integer>> list = new ArrayList<>(lis);

        int m = list.size() - 1;
        int n = list.get(0).size() - 1;
        Queue<node> queue = new LinkedList<>();
        /**
         * Add all the nodes with value 1 to the inp
         */

        ArrayList<node> inp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == 1) {
                    queue.add(new node(i, j, true));
                }
            }
        }

        //Its a delimeter
        queue.add(new node(-1, -1, false));
        int ans = 0;

        while (!queue.isEmpty()) {

            ans++;
            while (!isDelimeter(queue.peek())) {

                node temp = queue.poll();
                int xx = temp.x;
                int yy = temp.y;

                if (list.get(xx).get(yy) == 1 && temp.isDef) {
                    list.get(xx).set(yy, Integer.MAX_VALUE);
                }

                //right
                if (isValid(temp.x, temp.y + 1, m, n)) {
                    int x = temp.x;
                    int y = temp.y + 1;
                    if (list.get(x).get(y) == 0) {
                        list.get(x).set(y, ans);
                        queue.add(new node(x, y, false));
                    }


                }
                //check left
                if (isValid(temp.x, temp.y - 1, m, n)) {
                    int x = temp.x;
                    int y = temp.y - 1;
                    if (list.get(x).get(y) == 0) {
                        list.get(x).set(y, ans);
                        queue.add(new node(x, y, false));
                    }


                }

                //down
                if (isValid(temp.x + 1, temp.y, m, n)) {
                    int x = temp.x + 1;
                    int y = temp.y;
                    if (list.get(x).get(y) == 0) {
                        list.get(x).set(y, ans);
                        queue.add(new node(x, y, false));
                    }
                }

                //up
                if (isValid(temp.x - 1, temp.y, m, n)) {
                    int x = temp.x - 1;
                    int y = temp.y;
                    if (list.get(x).get(y) == 0) {
                        list.get(x).set(y, ans);
                        queue.add(new node(x, y, false));
                    }
                }


            }
            queue.poll();
            if (!queue.isEmpty()) queue.add(new node(-1, -1, false));


        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == Integer.MAX_VALUE) {
                    lis.get(i).set(j, 0);
                }
            }
        }
        return list;

    }

    private boolean isDelimeter(node peek) {
        return peek.x == -1 && peek.y == -1 && peek.isDef == false;
    }


    private boolean isValid(int x, int y, int m, int n) {

        return (x >= 0 && x <= m) && (y >= 0 && y <= n);
    }
}
