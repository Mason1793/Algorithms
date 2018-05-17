package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution s=new Solution();
        int[] arr={1,3,3,3,3,4,5};
        System.out.println(s.getFirstK(arr,0,arr.length-1,6));
        System.out.println(s.getLastK(arr,0,arr.length-1,6));
        System.out.println(s.GetNumberOfK(arr,6));
        //System.out.println(s.getLastK(arr,0,arr.length,3));
    }

    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root==null)return 0;

        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return (left>right)?left+1:right+1;
    }
    /**
     * 统计一个数字在排序数组中出现的次数
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0)return 0;
        int first=getFirstK(array,0,array.length-1,k);
        int last=getLastK(array,0,array.length-1,k);
        if(first==-1||last==-1)return 0;
        return last-first+1;
    }
    public int getFirstK(int[] array,int lo,int hi,int k){
        if(lo>hi)return -1;
        int mid=(lo+hi)/2;
        if(array[mid]==k){
            if((mid>0&&array[mid-1]!=k)||mid==0){
                return mid;
            }else {
                hi=mid-1;
            }
        }else if(array[mid]>k){
            hi=mid-1;
        }else {
           lo=mid+1;
        }
        return getFirstK(array,lo,hi,k);
    }
    public int getLastK(int[] array,int lo,int hi,int k){
        if(lo>hi)return -1;
        int mid=(lo+hi)/2;
        if(array[mid]==k){
            if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1){
                return mid;
            }else {
                lo=mid+1;
            }
        }else if(array[mid]>k){
            hi=mid-1;
        }else {
            lo=mid+1;
        }
        return getLastK(array,lo,hi,k);
    }
    /**
     * 寻找两个链表中的公共结点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)return null;

        int cnt1=0,cnt2=0;
        ListNode p1=pHead1,p2=pHead2;
        while (p1!=null){
            cnt1++;
            p1=p1.next;
        }
        while (p2!=null){
            cnt2++;
            p2=p2.next;
        }

        if(cnt1>cnt2){
            int step=cnt1-cnt2;
            p1=pHead1;
            while(step!=0){
                step--;
                p1=p1.next;
            }
            p2=pHead2;
            while(p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        }

        if(cnt1<cnt2){
            int step=cnt2-cnt1;
            p2=pHead2;
            while(step!=0){
                step--;
                p2=p2.next;
            }
            p1=pHead1;
            while(p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        }
        return null;
    }


}
