package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class blockcrusher {
    static class Node {
        int x, y, dist;
        Node prev;

        public Node(int x, int y, int dist, Node prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String inputLens[] = bf.readLine().split("\\s");
            int rows = Integer.parseInt(inputLens[0]);
            int cols = Integer.parseInt(inputLens[1]);
            /**
             * If entered row and col is 0 , break the loop
             */
            if (rows == 0 && cols == 0) break;
            List<List<String>> grid = new ArrayList<>();
            int rowIterator = 0;
            /**
             * Read the input for blocks
             */
            while (rowIterator < rows) {
                String rowInput[] = bf.readLine().split("");
                grid.add(Arrays.asList(rowInput));
                rowIterator++;
            }
            /**
             * distance to store the minimum distance till i,j
             */
            int distance[][] = new int[rows][cols];
            for (int i = 0; i < cols; i++) {
                distance[0][i] = Integer.parseInt(grid.get(0).get(i));
            }
            for (int i = 1; i < rows; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            Queue<Node> queue = new LinkedList<>();
            ArrayList<Node> resList = new ArrayList<>();
            /**
             * Add all the starting row nodes into the queue
             */
            for (int c = 0; c < cols; c++) {
                queue.add(new Node(0, c, Integer.parseInt(grid.get(0).get(c)), null));
            }

            //BottomLeftD,bottom,BottomRightD,topLeftD,top,topRightD,left,right
            int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
            int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};


            while (!queue.isEmpty()) {

                Node node = queue.poll();
                /**
                 * If the node belongs to the last row add it to the resList
                 */
                if (node.x == rows - 1) {
                    resList.add(node);
                }
                /**
                 * Traverse all possible directions and add it list if required
                 */

                for (int i = 0; i < dx.length; i++) {

                    int nextRow = node.x + dx[i];
                    int nextCol = node.y + dy[i];
                    if (isValid(nextRow, nextCol, rows, cols)) {
                        if (node.dist + Integer.parseInt(grid.get(nextRow).get(nextCol)) < distance[nextRow][nextCol]) {
                            distance[nextRow][nextCol] = node.dist + Integer.parseInt(grid.get(nextRow).get(nextCol));
                            queue.add(new Node(nextRow, nextCol, distance[nextRow][nextCol], node));
                        }
                    }
                }
            }
            /**
             * Find the node with minCost to reach the end of the block
             */
            Node nodeWithLeastDistance = resList.get(0);
            for (int i = 1; i < resList.size(); i++) {
                if (nodeWithLeastDistance.dist > resList.get(i).dist) {
                    nodeWithLeastDistance = resList.get(i);
                }
            }
            /**
             * Traverse the linkedlist and set the picket element to " "
             */
            while (nodeWithLeastDistance != null) {
                grid.get(nodeWithLeastDistance.x).set(nodeWithLeastDistance.y, " ");
                nodeWithLeastDistance = nodeWithLeastDistance.prev;
            }
            StringBuilder sb = new StringBuilder();
            for (List<String> stringArrayList : grid) {
                for (String element : stringArrayList) {
                    sb.append(element);
                }
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
            System.out.println();
        }
    }

    private static boolean isValid(int nextRow, int nextCol, int rows, int cols) {
        return nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols;
    }
}
