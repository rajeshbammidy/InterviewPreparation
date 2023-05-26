package TopicWiseSolutions.Graphs;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|BlackShapes| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class BlackShapes {
    static class node {
        int x;
        int y;

        node(int i, int j) {
            x = i;
            y = j;
        }
    }


    public int black(ArrayList<String> str) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        for (int i = 0; i < str.size(); i++) {
            ArrayList<Character> temp = new ArrayList<>();
            String s = str.get(i);
            for (int j = 0; j < s.length(); j++) {
                temp.add(s.charAt(j));

            }
            list.add(temp);
        }
        int m = list.size() - 1;
        int n = list.get(0).size() - 1;

        ArrayList<node> inp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {

                if (list.get(i).get(j) == 'X') inp.add(new node(i, j));
            }
        }
        int ans = 0;
        for (int i = 0; i < inp.size(); i++) {
            node temp = inp.get(i);
            int x = temp.x;
            int y = temp.y;

            if (list.get(x).get(y) == 'X') {
                bfs(list, temp, m, n);
                ans++;
            }
        }
        return ans;
    }


    private void bfs(ArrayList<ArrayList<Character>> list, node root, int m, int n) {
        Queue<node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node temp = queue.poll();
            list.get(temp.x).set(temp.y, '-');

            //right
            if (isValid(temp.x, temp.y + 1, m, n)) {
                int x = temp.x;
                int y = temp.y + 1;
                if (list.get(x).get(y) == 'X') {

                    queue.add(new node(x, y));
                }


            }
            //check left
            if (isValid(temp.x, temp.y - 1, m, n)) {
                int x = temp.x;
                int y = temp.y - 1;
                if (list.get(x).get(y) == 'X') {

                    queue.add(new node(x, y));
                }


            }

            //down
            if (isValid(temp.x + 1, temp.y, m, n)) {
                int x = temp.x + 1;
                int y = temp.y;
                if (list.get(x).get(y) == 'X') {

                    queue.add(new node(x, y));


                }
            }

            //up
            if (isValid(temp.x - 1, temp.y, m, n)) {
                int x = temp.x - 1;
                int y = temp.y;
                if (list.get(x).get(y) == 'X') {

                    queue.add(new node(x, y));


                }
            }

        }
    }


    private boolean isValid(int x, int y, int m, int n) {

        return (x >= 0 && x <= m) && (y >= 0 && y <= n);
    }
}
