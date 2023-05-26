package TopicWiseSolutions.Hashing;

import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Hashing|JewelsandStones| on May,2020
 *  
 * Happy Coding :)
 * <p>
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 **/
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for (char ch : J.toCharArray()) {
            if (map.get(ch) != null) {
                sum += map.get(ch);
            }
        }
        return sum;

    }
}
