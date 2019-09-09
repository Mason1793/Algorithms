package exam.bytedance;

import java.util.Scanner;

public class Main {

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] nums=new int[n];
//        for(int i=0;i<n;i++){
//            nums[i]=sc.nextInt();
//        }
//
//        int[] f=new int[n];
//        int max=0;
//        int height=0;
//        for(int i=0;i<nums.length-1;i++){
//            int temp=0;
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[j]>temp&&nums[j]<=nums[i]){
//                    f[i]=f[i]+1;
//                    if(f[i]>max){
//                        height=nums[i];
//                        max=f[i];
//                    }
//                    temp=Math.max(temp, nums[j]);
//                }else{
//                    break;
//                }
//            }
//        }
//        System.out.println(height);
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        int[] array=new int[n+1];
        array[0]=-99;

        int j=1;
        //输入？？
        for(int i=0;i<n;i++){
            String ss=sc.next();
            if(ss.charAt(0)=='<'||ss.charAt(0)=='>'){
                array[j]=ss.charAt(0);
            }else {
                array[j]=Integer.parseInt(ss);
            }
            j++;

        }

        for(int i=0;i<q;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();
            int lastStep=0;
            j=l-1;
            int res=0;
            int plus=1;
            int[] temp=new int[n];
            while (true){
                if(j>r||j<l||fun(temp,l,r)){
                    break;
                }
                int step=array[j];
                if(step==(int)('<')){
                    plus=-1;
                    if(lastStep==(int)('<')||lastStep==(int)('>')){
                        array[j]=-99;
                    }
                }else if(step==(int)('>')){
                    plus=1;
                    if(lastStep==(int)('<')||lastStep==(int)('>')){
                        array[j]=-99;
                    }
                }else if(step==0){
                    array[j]=-99;
                }else if(step==-99){

                } else {
                    res+=step;
                    array[j]=step-1;
                }
                lastStep=step;
                j=j+plus;
            }
            System.out.println(""+res);
        }
    }

    public static boolean fun(int[] temp,int l,int r){
        for(int i=l;i<=r;i++){
            if(temp[i]!=-99){
                return false;
            }
        }
        return true;
    }
}