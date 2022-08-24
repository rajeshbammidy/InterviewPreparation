package ScalerAcademy.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Given a string A consisting of lowercase English alphabets. Find and return lexicographically smallest string B after removing duplicate letters from A so that every letter appears once and only once.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return lexicographically smallest string B after removing duplicate letters from A.
 * Constraints
 *
 * 1 <= length of the string <= 200000
 * A consists of lowercase English alphabets only.
 * For Example
 *
 * Input 1:
 * A = "cbacdcbc"
 * Output 1:
 * B = "acdb"
 *
 * Input 2:
 * A = "bcabc"
 * Output 2:
 * B = "abc"
 *
 *
 *
 * Appraoch: Use a running hashmap to add the elements into the stack
 * 1.If the element exist on the right decide between retaining and deleting
 * 2.If doesnt exists on the right keep it.
 */
public class RemoveDuplicateLetters {
    public String solve(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (Character x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (stack.isEmpty()) {
                addCharacter(ch, stack, set, map);
                continue;
            }

            if (stack.peek() < ch) {
                if (!set.contains(ch)) {
                    addCharacter(ch, stack, set, map);
                }

            } else {
                while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) >= 1 && !set.contains(ch)) {

                    char x = stack.pop();
                    set.remove(x);

                }
                if (!set.contains(ch)) {
                    addCharacter(ch, stack, set, map);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private void addCharacter(char ch, Stack<Character> stack, HashSet<Character> set, HashMap<Character, Integer> map) {
        stack.push(ch);
        set.add(ch);
        map.put(ch, map.get(ch) - 1);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().solve("nsutwcgpgpxonqbzsvpmjksjminhitsfenbhowixva"));
    }

}
