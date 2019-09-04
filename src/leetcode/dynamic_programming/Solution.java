package leetcode.dynamic_programming;

/**
 * @author Mason
 * @date 2019-09-04
 */
public class Solution {
    public static void main(String[] args){
       int[] nums = {2,7,9,3,1};
       new Solution().rob(nums);
    }
    /**
     * 198
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            f[i] = Math.max(f[i-1],f[i-2]+nums[i]);
        }
        System.out.println(f[nums.length-1]);
        return f[nums.length-1];
    }

    /**
     * 279
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     * 你需要让组成和的完全平方数的个数最少。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] f = new int[n+1];
        for(int i=1;i<=n;i++){
            f[i] = i;
            for(int j=1;i>=j*j;j++){
                f[i] = Math.min(f[i],f[i-j*j]+1);
            }
        }
        return f[n];
    }





}
