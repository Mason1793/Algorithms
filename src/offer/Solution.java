package offer;

import java.util.Stack;

public class Solution {
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

    public static void main(String[] args){

    }
}
