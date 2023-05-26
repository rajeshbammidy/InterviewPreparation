package TopicWiseSolutions.Stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Stacks|NGR| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class NGR {
    public static int[] getNGR(int arr[]) {
        int ans[] = new int[arr.length];
        ans[arr.length - 1] = -1;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < arr.length) {

            while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                stack.add(i);
                i++;
            }
            if (i + 1 < arr.length) {
                ans[i] = arr[i + 1];
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i + 1]) {
                    ans[stack.pop()] = arr[i + 1];
                }
            }
            i = i + 1;
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNGR(new int[]{5,4,3,2,1})));
    }
}
