import java.lang.*;
import java.util.*; 
import java.io.*; 
import java.math.*;

class SpecialNumber {
   public static long[] findMin(long arr[],long x,long y,long z){
        long result[]=new long[2];
       if(arr[0]<=arr[1]){
              if(arr[0]<arr[2]){
                    result[0]=arr[0];
                    result[1]=x+y;
                    return result;
              }
           
       }else{
             if(arr[1]<=arr[2]){
                 
                  result[0]=arr[1];
                    result[1]=x+z;
                    return result;
             }
           
           
       }
         result[0]=arr[2];
         result[1]=y+z;
         return result;
         
   }
   public static long calResult(int n){
   
            long a=3,b=5,c=7;
            long prev_result[]=new long[2];
            long min[]=new long[2];
            boolean flag=false;
            int i=1;
           
            while(true){
               long x=(long)Math.pow(3,i);
               long y=(long)Math.pow(5,i);
               long z=(long)Math.pow(7,i);
               long arr[]=new long[3];
               arr[0]=Math.abs(n-(x+y));
               arr[1]=Math.abs(n-(x+z));
               arr[2]=Math.abs(n-(y+z));
               
               min=findMin(arr,x,y,z);
               if(flag && prev_result[0]<min[0]){
                     return prev_result[1];
               }
               if(min[1]>=n){
                     return min[1];
               }
               flag=true;
               prev_result=min;
               i++;
               
            }
   }
   public static long calCost(int n,int inc,int dec){
       
              long result=calResult(n);
               System.out.print(result+" ");
              if(result<n){
                   return (dec*(n-result));
              }else if(result>n){
                    return (inc*(result-n));
              }
                return 0;
   }
   
public static void main (String[] args) {
 
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int inc_cost=sc.nextInt();
   int dec_cost=sc.nextInt();
   System.out.println(calCost(n,inc_cost,dec_cost));

}
}
