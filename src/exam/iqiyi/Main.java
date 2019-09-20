package exam.iqiyi;

import java.util.Scanner;

/**
 * @author Mason
 * @date 2019-09-18
 */
public class Main {
    /**
     * 假设有N个人要玩游戏，每轮游戏必须选出一个人当裁判，剩下的N-1个人作为玩家。
     * 现在第i个人要求作为玩家进行至少Ai轮游戏，那么至少需要进行多少轮游戏才能满足所有人的要求？
     *
     * 3
     * 2 2 3
     *
     * 4
     * @param args
     */
    public static void main(String[] args){
        System.out.print((4|2)^(3|4));
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }

        int max=0;
        int min=99999;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        if(min+nums[1]>max){
            max=min+nums[1];
        }


        System.out.print(max);

    }
}
