package TopicWiseSolutions.Stacks;

import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Stacks|RemoveKDigits| on May,2020
 *  
 * Happy Coding :)
 **/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < num.length() && k > 0) {

            /**
             * If stack is empty then insert the element
             */
            if (stack.isEmpty()) {
                stack.push(Integer.parseInt(num.charAt(i++) + ""));
                continue;
            }

            /**
             * If the existing element is greater than the current element the pop it
             * if the current element is greater than the existing element lets push into the stack
             */
            if (stack.peek() > Integer.parseInt(num.charAt(i) + "")) {

                while (k > 0 && !stack.isEmpty() && stack.peek() > Integer.parseInt(num.charAt(i) + "")) {
                    k--;
                    stack.pop();
                }
                stack.push(Integer.parseInt(num.charAt(i++) + ""));

            } else {
                stack.push(Integer.parseInt(num.charAt(i++) + ""));
            }

        }
        /***
         * Since we are pushing the greater element this will help us in removing the greater elements from the stack
         */
        while (k > 0) {
            stack.pop();
            k--;
        }

        String str = "";
/**
 * Copy the elements into the string
 */
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }

        /**
         * Remove preceeding zeroes
         */
        while (!str.isEmpty() && str.charAt(0) == '0') {
            if (str.length() > 1)
                str = str.substring(1);
            else str = "";
        }

        while (i < num.length()) str += num.charAt(i++);
        if (str.isEmpty()) return "0";
        return str;

    }
}
