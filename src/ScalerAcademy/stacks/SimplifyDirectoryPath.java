package ScalerAcademy.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class SimplifyDirectoryPath {
    public String simplifyPath(String str) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        StringBuilder mSb = new StringBuilder();
        while (i < str.length()) {
            if (str.charAt(i) == '/' && i - 1 >= 0 && str.charAt(i) == str.charAt(i - 1)) {
                i++;
                continue;
            }
            mSb.append(str.charAt(i));
            i++;
        }
        String splitArray[] = mSb.toString().split("/");
        for (String x : splitArray) {
            if (x.isEmpty() || x.equals(".")) {
                continue;
            } else if (x.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(x);
            }
        }
        String res = "";
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) return "/";
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyDirectoryPath().simplifyPath("/home/foo"));
    }
}
