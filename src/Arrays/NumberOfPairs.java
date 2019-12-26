package Arrays;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|NumberOfPairs.java| on Jul,2019
 * Happy Coding :)
 *
 *Find number of pairs (x, y) in an array such that x^y > y^x
 * Expected  O(nLogn + mLogn) time
 */
public class NumberOfPairs {

	public static void main(String[] args) {
		
		 int x[] = {2, 1, 6}; 
	     int y[] = {1, 5}; 
	     
	     System.out.println(CountPairs(x,y));

	}

	private static int CountPairs(int[] x, int[] y) {
	//Create a exceptional Array upto 5 and set the count of 0,1,2,3,4 in the arrray y
		int excp[]=new int[5];
		for(int i=0;i<y.length;i++) {
			if(y[i]<5) {
				excp[y[i]]++;
			}
		}
		Arrays.sort(y);//we must sort inorder to perform binary search
		 int count=0;
		 for(int i=0;i<x.length;i++) {
			 count+=obtainCount(x[i],y,y.length,excp);
			 
		 }
		 return count;
		
		
		
		
	}

	private static int obtainCount(int elem, int[] y, int n, int[] excp) {
		if(elem==0)return 0;
		else if(elem==1)return excp[0];
		
		int idx=Arrays.binarySearch(y, elem);
		int ans;
		if(idx<0) {
			
			ans= n- Math.abs(idx+1);
			
		}else {

			while(idx<n && y[idx]==elem)idx++;
			ans= n-idx;
		}
		
		ans+=(excp[0]+excp[1]);
		
		if(elem==2)
			ans=ans-(excp[3]+excp[4]);
		
		if(elem==3)ans+=excp[2];
		return ans;
	
		
	}

}
