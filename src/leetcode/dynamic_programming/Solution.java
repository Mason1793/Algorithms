package leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import leetcode.dynamic_programming.TreeNode;
/**
 * @author Mason
 * @date 2019-09-04
 */
public class Solution {
    /**
     * 53
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = f[0];
        for(int i=1;i<nums.length;i++){
            if(f[i-1]>0){
                f[i] = f[i-1]+nums[i];
            }else{
                f[i] = nums[i];
            }
            
            max = Math.max(max,f[i]);
        }
        return max;
    }
    
    /**
     * 70
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int f = 1;
        int f1 = 2;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int res = 0;
        for(int i=3;i<=n;i++){
            res = f+f1;
            f = f1;
            f1 = res;
            
        }
        System.out.println(res);
        return res;
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

    /**
     * 322
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        for(int i=1;i<=amount;i++){
            f[i] = amount+1;
            for(int j=0;j<coins.length;j++){
                int v = coins[j];
                if(i-v<0){
                    continue;
                }
                f[i] = Math.min(1+f[i-v],f[i]);
            }
        }
        System.out.println(f[amount]);
        return f[amount]>amount?-1:f[amount];
    }

    /**
     * 128
     * hard!
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int val : set){
            if(!set.contains(val-1)){
                int temp_max = 1;
                int temp_val = val;
                while(set.contains(temp_val+1)){
                    temp_max++;
                    temp_val++;
                }
                max = Math.max(temp_max,max);
            }
        }
       
        System.out.println(max);
        return max;
    }

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int max_length = 0;
        int[] f = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            f[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    f[i] = Math.max(f[j]+1, f[i]);
                }
            }
            max_length = Math.max(max_length, f[i]);
        }
        System.out.println(max_length);
        return max_length;
    }
    /**
     * 395
     * 至少有K个重复字符的最长子串
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 
     * 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int[] f = new int[26];
        int res=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            f[c-'a']=f[c-'a']+1;
            
        }
        for(int i=0;i<f.length;i++){
            if(f[i]>=k){
                res+=f[i];
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        new Solution().maxSubArray(nums);
     }
}
