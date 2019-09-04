package leetcode;


/**
 * @author Mason
 * @date 2018/7/13
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        //System.out.println(s.mergeTwoLists());

        // System.out.println(s.convert("PAYPALISHIRING", 4));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            ListNode temp;
            if (p.val <= q.val) {
                temp = new ListNode(p.val);
                p = p.next;
            } else {
                temp=new ListNode(q.val);
                q=q.next;
            }
            cur.next = temp;
            cur = cur.next;
        }

        while (q!=null) {
            ListNode temp = new ListNode(q.val);
            q = q.next;
            cur.next = temp;
            cur = cur.next;
        }

        while (p!=null) {
            ListNode temp = new ListNode(p.val);
            p = p.next;
            cur.next = temp;
            cur = cur.next;
        }


        return res;
    }
}
