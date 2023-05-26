package TopicWiseSolutions.Graphs;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|CloneGraph| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Integer, Node> newMap;
    HashMap<Integer, Node> oldMap;
    Node start = null;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        newMap = new HashMap<>();
        oldMap = new HashMap<>();
        newMap.put(1, new Node(1));
        oldMap.put(1, node);
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(1, true);
        start = newMap.get(1);
        for (Node x : node.neighbors) {
            newMap.put(x.val, new Node(x.val));
            oldMap.put(x.val, x);
            queue.add(x.val);
            visited.put(x.val, true);
            newMap.get(1).neighbors.add(newMap.get(x.val));

        }

        while (!queue.isEmpty()) {

            int q = queue.poll();


            for (Node x : oldMap.get(q).neighbors) {

                if (!newMap.containsKey(x.val))
                    newMap.put(x.val, new Node(x.val));
                if (!oldMap.containsKey(x.val))
                    oldMap.put(x.val, x);
                if (!visited.containsKey(x.val)) {
                    queue.add(x.val);
                    visited.put(x.val, true);
                }

                newMap.get(q).neighbors.add(newMap.get(x.val));


            }

        }
        return start;

    }
}
