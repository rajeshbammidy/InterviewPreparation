package Hashing;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|SubArrayWithSum0.java| on Dec,2019
 * Happy Coding :)
 */
public class SubArrayWithSum0 {
    public int solve(ArrayList<Integer> list) {
        long psum=0;
        LinkedHashSet<Long> set=new LinkedHashSet<>();
        for(int x:list){
            psum+=x;

            if(set.contains(psum) || psum==0)return 1;
            else {
                set.add(psum);
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
