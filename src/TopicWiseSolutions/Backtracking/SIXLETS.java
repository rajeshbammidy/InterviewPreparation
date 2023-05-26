package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|SIXLETS| on May,2020
 *  
 * Happy Coding :)
 * Problem Description
 * Given a array of integers A of size N and an integer B. Return number of non-empty subsequences of A of size B having sum <= 1000.
 *
 *
 * Problem Constraints
 * 1 <= N <= 20 1 <= A[i] <= 1000 1 <= B <= N
 *
 *
 * Input Format
 * The first argument given is the integer array A. The second argument given is the integer B.
 *
 *
 * Output Format
 * Return number of subsequences of A of size B having sum <= 1000.
 *
 *
 * Example Input
 * Input 1:
 *     A = [1, 2, 8]
 *     B = 2
 * Input 2:
 *     A = [5, 17, 1000, 11]
 *     B = 4
 *
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *  {1, 2}, {1, 8}, {2, 8}
 **/
public class SIXLETS {
    static  int c=0;
    public int solve(ArrayList<Integer> list, int size) {
        c=0;
        int n=list.size();

        generate(0,0,list,n,size,0);
        return c;
    }

    private void generate( int start,int curlen,ArrayList<Integer> list, int n, int size, int sum) {

        if(curlen==size && sum<=1000){
            c++;
            return;
        }
        if (sum>1000)return;

        for(int i=start;i<n;i++){
            sum+=list.get(i);
            generate(i+1,curlen+1,list,n,size,sum);
            sum=sum-list.get(i);

        }
    }

}
