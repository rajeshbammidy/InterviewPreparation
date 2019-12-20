package Hashing;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 *
 * Find pairs in array whose sum is already present
 * Given an array A of N distinct and positive elements, the task is to find number of unordered pairs whose sum already exists in given array. Expected Complexity : n^2 CONSTRAINTS
 * 1 <= N <= 1000
 * 1 <= A[i] <= 10^6 + 5
 * SAMPLE INPUT
 * A : [ 3, 4, 2, 6 ,7]
 * SAMPLE OUTPUT
 * 2
 * EXPLANATION
 * The pairs following the conditions are :
 * (2,4) = 6,
 * (3,4) = 7
 *
 *
 * public int solve(ArrayList<Integer> arr) {
 *         LinkedHashSet<Integer> list=new LinkedHashSet<>();
 *         for(int x:arr)list.add(x);
 *         int ans=0;
 *         for (int i = 0; i < list.size(); i++) {
 *             for (int j = i + 1; j < list.size(); j++) {
 *                 int sum = arr.get(i) + arr.get(j);
 *                 if(list.contains(sum))ans++;
 *             }
 *         }
 *         return ans;
 *     }
 */
public class FindPairs {
}
