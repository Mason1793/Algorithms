package exam.huawei;



import java.util.Scanner;

/**
 * @author Mason
 * @date 2019-09-11
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String stIn=in.nextLine();
        String[] temp=stIn.split("},");
        String[] strA=temp[0].substring(3,temp[0].length()).split(",");
        String[] strB=temp[1].substring(3,temp[1].length()).split(",");
        int R=Integer.parseInt(temp[2].substring(2,temp[2].length()));
        int j=0;
        int indexB=0;
        if(strA.equals("")||strB.equals("")){
            System.out.print("");
            return;
        }
        for (int i=0;i<strA.length;i++){
            int A=Integer.parseInt(strA[i]);

            int B;
            j=0;
            while (j<strB.length){
                B=Integer.parseInt(strB[j]);
                if(A<=B && (B-A<=R)){
                    System.out.print("("+A+","+B+")");
                    break;
                }
                j++;
            }
            if(j==strB.length){
                int min=999999;
                int tp=0;
                for(j=0;j<strB.length;j++){
                    B=Integer.parseInt(strB[j]);
                    if(min>Math.abs(B-A)&&A<=B){
                        min=Math.abs(B-A);
                        tp=j;
                    }
                }
                B=Integer.parseInt(strB[tp]);
                if(A<B){
                    System.out.print("("+A+","+B+")");
                }

            }
        }

    }
}
//A={4,5,6},B={1,2,3},R=1
//A={4,5,6},B={7,8,9},R=1
//A={4,5,6},B={1,8,9},R=1
//A={1,3,5},B={2,4,6},R=1
//A={1,3,5},B={5,6,7},R=1