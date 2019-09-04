package leetcode.dynamic_programming;

/**
 * @author Mason
 * @date 2019-09-04
 */
public class Solution {
    public static void main(String[] args){
        new Solution().numSquares(1);
        new Solution().numSquares(2);
        new Solution().numSquares(3);
        new Solution().numSquares(4);

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
