package basealgorithms;

import java.util.Arrays;

class HeapSort{
    public static void main(String[] args){
        int[] nums={3,1,5,16,12,8,0,4};
        new HeapSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sort(int[] nums){
        int N=nums.length;
        for(int k=N/2-1;k>=0;k--)sink(nums,k,N);
        
        for(int j=nums.length-1;j>0;j--){
            int temp=nums[0];
            nums[0]=nums[j];
            nums[j]=temp;
            sink(nums,0,j);
        }
    }

    public void sink(int[] nums,int k,int n){
        int j;
        while((j=2*k+1)<n){
            if(j+1<n&&nums[j+1]>nums[j])j++;
            if(nums[k]>=nums[j])break;
            int temp=nums[k];
            nums[k]=nums[j];
            nums[j]=temp;
            k=j;
        }
    }
}