package TopicWiseSolutions.Sorting;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Sorting|FlightRangeBookings| on May,2020
 *  
 * Happy Coding :)
 **/
public class FlightRangeBookings {
    public ArrayList<Integer> solve(int k, ArrayList<ArrayList<Integer>> inp) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++)res.add(0);
        for(int i=0;i<inp.size();i++){
            ArrayList<Integer> list=inp.get(i);
            int val=list.get(2);
            int s=list.get(0)-1;
            int e=list.get(1)-1;

            res.set(s,res.get(s)+val);
            if(e+1<res.size())res.set(e+1,res.get(e+1)-val);
        }
        for(int i=1;i<res.size();i++){

            int sum=res.get(i-1)+res.get(i);
            res.set(i,sum);

        }
        return res;
    }
}
