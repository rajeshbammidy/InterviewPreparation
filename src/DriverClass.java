/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Sep,2019
 * Happy Coding :)
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class DriverClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

class DetectCycle
{
    static boolean isCycle(int src,ArrayList<ArrayList<Integer>> list,boolean vis[],Stack<Integer> stack){

        // if(stack.contains(src))return true;
        // if(vis[src])return false;

        if(!vis[src]){
            vis[src]=true;
            stack.push(src);

        }

        ArrayList<Integer> cur=list.get(src);
        for(int i=0;i<cur.size();i++){

            if(!vis[cur.get(i)]){
                isCycle(cur.get(i),list,vis,stack);
            }else{
                if(stack.contains(cur.get(i)))return true;
            }
        }
        stack.pop();
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean vis[]=new boolean[V];
        Stack<Integer> stack=new Stack();

        for(int i=0;i<V;i++){
            if(!vis[i])
                if(isCycle(i,list,vis,stack))
                    return true;
        }

        return false;
    }
}
