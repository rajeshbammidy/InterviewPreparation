

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */

class Trie {

    static class Node {
        HashMap<Character, Node> map = new HashMap<Character, Node>();
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

public class Test {

    public List<String> letterCombinations(String inp) {
        List<String> res = new ArrayList<>();
        if (inp.equals("")) return res;
        String str[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrackForStrings(res, 0, inp, "", str);
        return res;
    }

    private void backtrackForStrings(List<String> res, int i, String dig, String aux, String[] inp) {
        if (i == dig.length()) {
            res.add(aux);
            return;
        }
        String sample = inp[Integer.parseInt(dig.charAt(i) + "")];
        for (int j = 0; j < sample.length(); j++) {
            backtrackForStrings(res, i + 1, dig, aux + sample.charAt(j), inp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test().letterCombinations("0"));
    }
}