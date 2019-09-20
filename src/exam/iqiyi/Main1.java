package exam.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mason
 * @date 2019-09-18
 */
public class Main1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int cnt=1;
        for (int i=0;i<n;i++){
            cnt*=2;
        }
        int[] nums=new int[cnt];
        for (int i=0;i<cnt;i++){
            nums[i]=in.nextInt();
        }

        for (int i=0;i<m;i++){
           int a1=in.nextInt();
           int a2=in.nextInt();

           nums[a1-1]=a2;
           int j=0;


            int[] temp=Arrays.copyOf(nums,cnt);
            int[] res=null;
           while (j<n){

               res=fun(temp,j);
               temp=res;
               j++;
           }

           System.out.println(res[0]);


        }


    }

    public static int[] fun(int[] nums,int op){
        int[] res=new int[nums.length/2];
        int index=0;
        for (int i=0;i<nums.length;i=i+2){
            if(op%2==0){
                res[index]=nums[i]|nums[i+1];
            }else {
                res[index]=nums[i]^nums[i+1];
            }
            index++;
        }
        return res;
    }
}
