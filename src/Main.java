

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Main {

    public boolean equationsPossible(String[] equations) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 26; i >= 1; i--) {
            integerStack.push(i);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (String eq : equations) {
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(1);
            char ch3 = eq.charAt(2);
            char ch4 = eq.charAt(3);
            if (ch2 == ch3) {
                Integer x = map.get(ch1);
                Integer y = map.get(ch4);
                if (x == null && y == null) {
                    if (integerStack.size() < 1) return false;
                    int value = integerStack.pop();
                    map.put(ch1, value);
                    map.put(ch4, value);
                } else if (x == null) {
                    map.put(ch1, y);
                } else if (y == null) {
                    map.put(ch4, x);
                } else {
                    if (x != y) return false;
                }

            } else {
                if (ch1 == ch4) return false;

                Integer x = map.get(ch1);
                Integer y = map.get(ch4);
                if (x == null && y == null) {
                    if (integerStack.size() < 2) return false;
                    map.put(ch1, integerStack.pop());
                    map.put(ch4, integerStack.pop());
                } else if (x == null) {
                    if (integerStack.size() < 1) return false;
                    map.put(ch1, integerStack.pop());
                } else if (y == null) {
                    if (integerStack.size() < 1) return false;
                    map.put(ch4, integerStack.pop());
                } else {
                    if (x == y) return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main().equationsPossible(new String[]{"a==b","b!=a"}));
    }


}

