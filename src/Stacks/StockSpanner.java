package Stacks;

import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Stacks|StockSpanner| on May,2020
 *  
 * Happy Coding :)
 **/
public class StockSpanner {
    Stack<int[]> s;

    public StockSpanner() {
        s = new Stack<>();
    }


    // If new price comes, keep popping stakc till price >= top price and accumulate its span
    public int next(int price) {
        int span = 1;
        while (!s.isEmpty() && price >= s.peek()[0]) {
            span += s.peek()[1];
            s.pop();
        }
        s.push(new int[]{price, span});
        return span;
    }
}
