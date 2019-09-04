package offer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args){

        Solution s=new Solution();

        System.out.println(s.LastRemaining_Solution(4000,997));
      
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        if(n==1){
            return 0;
        }
        return (LastRemaining_Solution(n-1,m)+m)%n;
    }

    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
     * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
     * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        if(numbers == null||numbers.length<=0){
            return false;
        }

        //统计0的个数
        int cnt0=0;
        int gap=0;
        for(int i=0;i<numbers.length&&numbers[i]==0;i++){
            cnt0++;
        }

        int small=cnt0,big=small+1;

        while(big<numbers.length){
            if(numbers[small]==numbers[big]){
                return false;
            }

            gap+=numbers[big]-numbers[small]-1;
            small=big;
            big++;
        }
        return cnt0>=gap?true:false;
    }

    /**
     * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
     * 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
     * 测试样例：
     * @param A
     * @param n
     * @return
     */
//    public char findFirstRepeat(String A, int n) {
//
//    }

    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
     * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
     * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if(str==null){
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        String[] s=str.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i =0;i<s.length;i++){
            StringBuilder sb=new StringBuilder(s[i]);

            result.append(sb.reverse());
            if(i!=s.length-1){
                result.append(" ");
            }

        }


        return result.reverse().toString();
    }
    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
     * 即“XYZdefabc”。是不是很简单？OK，搞定它！
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        String result=str;
        if(str!=null){
            if(str.length()>0&&n>0&&n<str.length()){
                StringBuilder s1=new StringBuilder(str.substring(0,n)).reverse();
                StringBuilder s2=new StringBuilder(str.substring(n,str.length())).reverse();
                s1.append(s2);
                result=s1.reverse().toString();
            }
        }
        return result;
    }
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int small,big;
        if (array.length >1 ) {
          small =0;
          big=array.length-1;
        }else {
            return result;
        }

        while(array[small]+array[big]!=sum&&small<big){
            if(array[small]+array[big]>sum){
                big--;
            }else {
                small++;
            }
        }
        if(small<big){
            result.add(array[small]);
            result.add(array[big]);
        }
        return result;
    }
    /**
     * 脑洞日天题
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp=array[0];
        for(int i=1;i<array.length;i++){
            temp=temp^array[i];
        }
        String by=Integer.toBinaryString(temp);

        int n=0;

        int indexBit=0;
        while(((temp&1)==0)&&(indexBit<8*32)){
            temp=temp>>1;
            ++indexBit;
        }

        System.out.println(by+","+indexBit);

        for(int i=0;i<array.length;i++){
            if(IsBit1(array[i],indexBit)==1){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }




    }
    int IsBit1(int num,int indexBit){
        num=num>>1;
        return (num&1);
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        AtomicInteger dep=new AtomicInteger();
        return IsBalanced(root,dep);
    }
    public boolean IsBalanced(TreeNode root, AtomicInteger depth){
        if(root==null){
            depth.set(0);
            return true;
        }
        AtomicInteger left=new AtomicInteger();
        AtomicInteger right=new AtomicInteger();

        if(IsBalanced(root.left,left)&&IsBalanced(root.right,right)){
            int diff=left.get()-right.get();
            if(diff>=-1&&diff<=1){
                depth.set(1+(left.get()>right.get()?left.get():right.get()));
                return true;
            }
        }

        return false;
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
