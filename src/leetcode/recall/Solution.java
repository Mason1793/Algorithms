package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mason
 * @date 2019-09-18
 */
public class Solution {
    public static void main(String[] args){
        int[] nums={1,2,3};
        new Solution().subsets(nums);
    }

    /**
     * 78
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> array=new ArrayList<>();
            addSet(nums,i,array,res);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void addSet(int[] nums,int begin,List array,List<List<Integer>> res){
        if(begin>=nums.length){
            return;
        }
        List array1=new ArrayList();
        array1.addAll(array);
        res.add(array1);

        for(int i=begin;i<nums.length;i++){
            List array2=new ArrayList();
            array2.addAll(array1);
            array2.add(nums[i]);
            addSet(nums,begin+1,array2,res);
        }
    }
}
