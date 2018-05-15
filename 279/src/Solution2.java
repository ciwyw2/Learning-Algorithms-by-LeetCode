import java.util.Arrays;

// 与 Solution1 是同一种写法
public class Solution2 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Integer.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        Solution2 solution = new Solution2();
        int numSquares = solution.numSquares(12);
        System.out.println(numSquares);
    }
}
