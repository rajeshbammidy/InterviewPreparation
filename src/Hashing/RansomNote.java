package Hashing;

import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|RansomNote| on May,2020
 *  
 * Happy Coding :)
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 **/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (map.get(ch) == null || map.get(ch) <= 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;

    }
}
