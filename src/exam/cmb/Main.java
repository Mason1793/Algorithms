package exam.cmb;

import java.util.Scanner;
class temp{
    int c=0;
}
public class Main {
    public static void main(String[] args){
        Main m=new Main();
        temp t=new temp();
        System.out.println(m.fun());
       
     
    }

    public int fun(){
        int i = 0;
        try{
           i = 1;
           return i;
        }finally{
           i = 2;
        }
    }
}
