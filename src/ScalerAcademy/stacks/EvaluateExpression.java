package ScalerAcademy.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each character may be an integer or an operator.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 *
 *
 * Input Format
 * The only argument given is character array A.
 *
 *
 *
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 *
 *
 *
 * Example Input
 * Input 1:
 *     A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 *     A = ["4", "13", "5", "/", "+"]
 *
 *
 * Example Output
 * Output 1:
 *     9
 * Output 2:
 *     6
 *
 *
 * Example Explanation
 * Explaination 1:
 *     starting from backside:
 *     * : () * ()
 *     3 : () * (3)
 *     + : (() + ()) * (3)
 *     1 : (() + (1)) * (3)
 *     2 : ((2) + (1)) * (3)
 *     ((2) + (1)) * (3) = 9
 * Explaination 2:
 *     + : () + ()
 *     / : () + (() / ())
 *     5 : () + (() / (5))
 *     13 : () + ((13) / (5))
 *     4 : (4) + ((13) / (5))
 *     (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
    private boolean isOperator(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("/") || ch.equals("%") || ch.equals("*");
    }

    public int evalRPN(ArrayList<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String str : list.toArray(new String[0])) {
            if (!isOperator(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                switch (str) {
                    case "+": {
                        c = a + b;
                        break;
                    }
                    case "-": {
                        c = b - a;
                        break;
                    }
                    case "*": {
                        c = a * b;
                        break;
                    }
                    case "/": {
                        c = b / a;
                        break;
                    }
                    case "%": {
                        c = b % a;
                        break;
                    }
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList(new String[]{"4", "13", "5", "/", "+"}))));
    }
}
