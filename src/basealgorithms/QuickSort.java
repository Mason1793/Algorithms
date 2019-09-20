package basealgorithms;

import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args){
        int[] nums={3,1,5,16,12,8,0,4};
        new QuickSort().sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums,int lo,int hi){
        if(lo>=hi)return;
        int j=partition(nums, lo, hi);
        sort(nums, lo, j-1);
        sort(nums, j+1, hi);
    }

    public int partition(int[] nums,int lo,int hi){
        int i=lo,j=hi+1;
        int v=nums[lo];
        while(true){
            while(v>nums[++i])if(i==hi)break;
            while(v<nums[--j])if(j==lo)break;
            if(i>=j)break;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        int temp=nums[j];
        nums[j]=nums[lo];
        nums[lo]=temp;

        return j;
    }
}