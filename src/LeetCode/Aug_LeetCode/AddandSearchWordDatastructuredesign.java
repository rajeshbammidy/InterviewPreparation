package LeetCode.Aug_LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Tries|AddandSearchWordDatastructuredesign| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class AddandSearchWordDatastructuredesign {
    static class Node {
        HashMap<Character, Node> map = new HashMap<>();
        boolean isEnd;

    }

    Node root;

    AddandSearchWordDatastructuredesign() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map.get(ch) == null) {
                Node newnode = new Node();
                node.map.put(ch, newnode);
            }
            node = node.map.get(ch);
        }
        node.isEnd = true;

    }

    public boolean searchReg(String word, Node root, int index) {
        if (index >= word.length()) return root.isEnd;
        char ch = word.charAt(index);


        if (ch == '.') {
            for (Map.Entry<Character, Node> x : root.map.entrySet()) {
                if (searchReg(word, x.getValue(), index + 1) == true) return true;

            }
            return false;
        }
        if (root == null || root.map.get(ch) == null) return false;

        return searchReg(word, root.map.get(ch), index + 1);


    }

    public static void main(String[] args) {
        AddandSearchWordDatastructuredesign obj = new AddandSearchWordDatastructuredesign();
        obj.insert("at");
        obj.insert("and");
        obj.insert("an");
        obj.insert("add");
        obj.insert("bat");

        System.out.println(obj.searchReg("b..", obj.root, 0));
    }

}
