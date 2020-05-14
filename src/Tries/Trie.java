package Tries;

import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Tries|ImplementTrie| on May,2020
 *  
 * Happy Coding :)
 **/
public class Trie {
    static class Node {
        HashMap<Character, Node> map = new HashMap<>();
        boolean isEnd;

    }

    /**
     * Initialize your data structure here.
     */
    Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
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

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map.get(ch) == null) return false;
            node = node.map.get(ch);

        }
        return node.isEnd;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.map.get(ch) == null) return false;
            node = node.map.get(ch);

        }
        return true;

    }
}
