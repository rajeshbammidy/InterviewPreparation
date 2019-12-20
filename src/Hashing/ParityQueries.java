package Hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Parity Queries
 * Given an empty multiset of integers initially and N queries to perform on it. + X — add non-negative integer X to the multiset. Note, that there may be many occurrences of the same integer. - X — delete a single occurrence of non-negative integer X from the multiset. It's guaranteed, that there is at least one X in the multiset. ? S — count the number of integers in the multiset (with repetitions) that match some pattern S consisting of 0 and 1. In the pattern, 0 stands for the even digits, while 1 stands for the odd. Integer X matches the pattern S, if the parity of the i'th from the right digit in decimal notation matches the i'th from the right digit of the pattern. If the pattern is shorter than this integer, it's supplemented with 0's from the left. Similarly, if the integer is shorter than the pattern its decimal notation is supplemented with the 0's from the left. For example, if the pattern is S = 010, than integers 92, 2212, 50 and 414 match the pattern, while integers 3, 110, 25 and 1030 do not. Given an array of characters A and an array of Strings B (representing the value of X for each query) of size N each, perform the queries and return the result for every third query in the form of an array of integers.
 * Input Format
 * The first argument given is the character array A.
 * The second argument given is the String array B.
 * Output Format
 * Return the answer for every third query in the form of an array of integers.
 * Constraints
 * 1 <= N <= 100000
 * A[i] = {'+', '-', '?'}
 * 0 <= B[i] <= 10^18  (given in the form of string)
 * For Example
 * Input 1:
 * A = ['+', '+', '-', '?']
 * B = [200, 200, 200, 0]
 * Output 1:
 * [1]
 * <p>
 * Input 2:
 * A = ['+', '+', '?', '+', '-', '?']
 * B = [1, 241, 1, 361, 241, 101]
 * Output 2:
 * [2, 1]
 */
public class ParityQueries {
    public ArrayList<Integer> solve(ArrayList<Character> characters, ArrayList<String> numbers) {
        LinkedHashMap<Long, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            long bform = getLongForm(numbers.get(i));

            switch (characters.get(i)) {

                case '+':
                    if (!map.containsKey(bform)) {
                        map.put(bform, 1);
                    } else {
                        map.put(bform, map.get(bform) + 1);
                    }
                    break;

                case '-':
                    if (map.containsKey(bform)) {
                        map.put(bform, map.get(bform) - 1);
                    }
                    break;
                case '?':
                    list.add(map.get(bform) == null ? 0 : map.get(bform));
                    break;


            }

        }

        return list;
    }

    private long getLongForm(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int n = Integer.parseInt(ch + "");
            if (n % 2 == 0) str += "0";
            else str += "1";
        }
        return Long.parseLong(str);
    }

    public static void main(String[] args) {
        ArrayList<Character> characters = new ArrayList<>(Arrays.asList(new Character[]{'+', '+', '?', '+', '-', '?'}));
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(new String[]{"1", "241", "1", "361", "241", "101"}));
        System.out.println(new ParityQueries().solve(characters, strings));
    }
}
