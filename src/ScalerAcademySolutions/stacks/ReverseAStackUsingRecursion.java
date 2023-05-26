package ScalerAcademySolutions.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class ReverseAStackUsingRecursion {
    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        ArrayDeque<Integer> deque = new ArrayDeque();
        for (int x : list) {
            deque.push(x);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        recursiveAns(deque, ans);
        return ans;
    }

    private void recursiveAns(ArrayDeque<Integer> deque, ArrayList<Integer> ans) {
        if (!deque.isEmpty()) {
            ans.add(deque.pop());
            recursiveAns(deque, ans);

        }
    }
}
