package ScalerAcademy.stacks;

import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 *
 * Check whether A has redundant braces or not.
 *
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return 1 if A has redundant braces else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "((a+b))"
 * Input 2:
 *
 * A = "(a+(a+b))"
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * ((a+b)) has redundant braces so answer will be 1.
 * Explanation 2:
 *
 * (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 *
 *
 * Approach: Check if every () and is being seperated by atleast one operator, we dont have anything to do with the operands so ignrore it.
 */
public class RedundantBraces {
    public int braces(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || isOperator(ch)) {
                stack.push(ch);
            } else if (ch == ')') {
                if (!isOperator(stack.peek())) return 1;
                while (isOperator(stack.peek())) {
                    stack.pop();
                }
                if (stack.peek() == '(') stack.pop();
            }
        }
        while (!stack.isEmpty() && isOperator(stack.peek())) stack.pop();
        return stack.isEmpty() ? 0 : 1;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '%' || ch == '*';
    }

    public static void main(String[] args) {
        System.out.println(new RedundantBraces().braces("(a*b)+(b*c)"));
    }
}
