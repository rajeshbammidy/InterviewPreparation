import java.util.*;


public class Test {
    public int bitwiseComplement(int n) {
        String bis=Integer.toBinaryString(n);
       String aux="";
       for(char ch:bis.toCharArray()){
           if(ch=='0'){
               aux+="1";
           }else{
               aux+="0";
           }
       }
        return Integer.valueOf(aux,2);

    }

    public static void main(String[] args) {
        System.out.println(new Test().bitwiseComplement(0));
    }
   }