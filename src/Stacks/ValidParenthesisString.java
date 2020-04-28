package Stacks;

import java.util.Stack;

public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') open.push(i);
            else if (ch == '*') star.push(i);
            else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty()){
            int in=open.pop();
            if(star.isEmpty())return false;
            if(star.pop()<in)return false;

        }
        return true;


    }
}
