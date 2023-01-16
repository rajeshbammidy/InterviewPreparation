

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Main {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Node(intervals[i][0], intervals[i][1]));
        }
        list.add(new Node(newInterval[0], newInterval[1]));
        list.sort((o1, o2) -> {
            return o1.x - o2.x;
        });
        ArrayList<Node> tempList = new ArrayList<>();
        tempList.add(list.get(0));
        int i = 1;
        while (i < list.size()) {
            Node cureNode = tempList.get(tempList.size() - 1);
            Node newNode = list.get(i);

            if (isOverlapping(newNode, cureNode)) {
                tempList.set(tempList.size() - 1, new Node(Math.min(cureNode.x, newNode.x), Math.max(
                        cureNode.y, newNode.y
                )));
            } else {
                tempList.add(newNode);
            }
            i++;
        }
        int ans[][] = new int[tempList.size()][2];
        i = 0;
        for (Node node : tempList) {
            ans[i][0] = node.x;
            ans[i++][1] = node.y;
        }
        return ans;

     /*   if (intervals.length == 0) {
            int ans[][] = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }
        boolean isNewMerged = false;
        Node newNode = new Node(newInterval[0], newInterval[1]);
        Node cureNode = new Node(intervals[0][0], intervals[0][1]);
        ArrayList<Node> list = new ArrayList<>();
        if (isOverlapping(newNode, cureNode)) {
            list.add(new Node(Math.min(cureNode.x, newNode.x), Math.max(
                    cureNode.y, newNode.y
            )));
            isNewMerged = true;

        } else
            list.add(new Node(intervals[0][0], intervals[0][1]));

        int i = 1;
        while (i < intervals.length) {
            if (!isNewMerged) {
                Node prevNode = list.get(list.size() - 1);
                cureNode = new Node(newInterval[0], newInterval[1]);
                newNode = new Node(intervals[i][0], intervals[i][1]);
                if (isOverlapping(prevNode, cureNode)) {
                    list.set(list.size() - 1, new Node(Math.min(prevNode.x, cureNode.x),
                            Math.max(prevNode.y, cureNode.y)));
                    isNewMerged = true;
                    continue;
                } else if (prevNode.x < cureNode.x && cureNode.x < newNode.x) {
                    list.add(cureNode);
                    isNewMerged = true;
                }
                list.add(newNode);
                i++;
            } else {
                Node prevNode = list.get(list.size() - 1);
                cureNode = new Node(intervals[i][0], intervals[i][1]);
                if (isOverlapping(prevNode, cureNode)) {
                    list.set(list.size() - 1, new Node(Math.min(prevNode.x, cureNode.x),
                            Math.max(prevNode.y, cureNode.y)));
                } else {
                    list.add(cureNode);
                }
                i++;


            }
        }
        if (!isNewMerged) {
            if (newNode.x < list.get(list.size() - 1).x) {
                ArrayList<Node> nodeList = new ArrayList<>();
                nodeList.add(newNode);
                nodeList.addAll(list);
                list = nodeList;
            } else
                list.add(newNode);
        }
        int ans[][] = new int[list.size()][2];
        i = 0;
        for (Node node : list) {
            ans[i][0] = node.x;
            ans[i++][1] = node.y;
        }
        return ans;*/

    }

    private boolean isOverlapping(Node prevNode, Node curNode) {
        return prevNode.x <= curNode.y && curNode.x <= prevNode.y;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Main().insert(new int[][]{{1,3},{6,9}},new int[]{2,5})));;
    }


}

