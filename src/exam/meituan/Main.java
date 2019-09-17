package exam.meituan;

import java.util.Scanner;

/**
 * @author Mason
 * @date 2019-09-11
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        String n1 = in.nextLine();
        String n2 = in.nextLine();

        char[] charry1=n1.toCharArray();
        char[] charry2=n2.toCharArray();
        int istart=0,jstart=0;
        boolean isSub=false;
        if(charry1[0]=='-'&&charry2[0]=='-'){
            istart=1;
            jstart=1;
        }else if(charry1[0]=='-'&&charry2[0]!='-'){
            istart=1;
            jstart=0;
            isSub=true;
        }else if(charry1[0]!='-'&&charry2[0]=='-'){
            istart=0;
            jstart=1;
            isSub=true;
        }

        if(n1.length()-istart<n2.length()-jstart){
            String temp=n1;
            n1=n2;
            n2=temp;

            int t=istart;
            istart=jstart;
            jstart=t;
        }


        boolean isOver=false;
        String res="";
        int i=n1.length()-1,j=n2.length()-1;
        for(;i>=istart&&j>=jstart;i--,j--){
            int c1=n1.charAt(i)-'0';
            int c2=n2.charAt(j)-'0';
            if(isSub){
                int sub=c1-c2;
                if(isOver){
                    sub-=1;
                }
                if(sub<0){
                    sub-=10;
                    isOver=true;
                }else {
                    isOver=false;
                }
                res=sub+res;
            }else {
                int sum=(c1+c2);
                if(isOver){
                    sum+=1;
                }
                if(sum>10){
                    sum-=10;
                    isOver=true;
                }else {
                    isOver=false;
                }
                res=sum+res;
            }
        }
        int index=(n1.length()-istart)-(n2.length()-jstart);
        for(int k=index;k>=0;k--){
            int v=n1.charAt(k)-'0';
            if(isSub){
                if(isOver){
                    v-=1;
                }
            }else {
                if(isOver){
                    v+=1;
                }
            }
            res=v+res;
        }
        System.out.println(res);
//        if(index>=0){
//            if(isOver){
//                int c1=(int)(charry1[index]-'0');
//                c1+=1;
//                res=c1+res;
//                res=n1.substring(istart,jstart+index)+res;
//            }else {
//                res=n1.substring(istart,jstart+index+1)+res;
//            }
//
//        }else {
//            if(isOver){
//                res='1'+res;
//            }
//        }
//        if(istart==1&&jstart==1){
//            res="-"+res;
//        }
//        System.out.println(res);


    }
}
