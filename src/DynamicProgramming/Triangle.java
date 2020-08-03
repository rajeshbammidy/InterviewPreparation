package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|Triangle| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp=new ArrayList<>(triangle.get(triangle.size()-1));
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<i;j++){
                dp.set(j,Math.max(dp.get(j),dp.get(j+1))+triangle.get(i).get(j));
            }
        }
        return dp.get(0);

    }
}
