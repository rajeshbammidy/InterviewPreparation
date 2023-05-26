package TopicWiseSolutions.Tries;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Tries|ShortestUniquePrefix| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class ShortestUniquePrefix {
    static class Node {
        HashMap<Character, Node> map = new HashMap<>();
        int count = 0;
        boolean isEnd;

        public Node(int count) {
            this.count = count;
        }
    }

    public ArrayList<String> prefix(ArrayList<String> words) {
        Node root = new Node(0);
        for (String x : words) {
            buildTrie(x, root);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String x : words) {
            findShortestPrefix(root, x, res);
        }
        return res;

    }

    private void findShortestPrefix(Node root, String x, ArrayList<String> res) {
        String aux = "";
        for (char ch : x.toCharArray()) {
            aux += ch;
            if (root.map.get(ch).count == 1) {
                res.add(aux);
                return;
            }
            root=root.map.get(ch);
        }
    }

    private void buildTrie(String x, Node root) {
        for (char ch : x.toCharArray()) {

            if (root.map.get(ch) == null) {
                root.map.put(ch, new Node(0));
            }
            root.map.get(ch).count += 1;

            root = root.map.get(ch);
        }
        root.isEnd = true;
    }
}
