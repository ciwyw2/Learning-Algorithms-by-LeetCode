// https://leetcode-cn.com/problems/ones-and-zeroes/description/
public class Solution {

    private int[] calcZeroAndOne(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int[] zeroAndOne = calcZeroAndOne(s);
            int zeros = zeroAndOne[0];
            int ones = zeroAndOne[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    // 一点一点填空
                    dp[i][j] = Integer.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // write your code here
        String[] strs = {"10", "0001", "111001", "1", "0"};
        Solution solution = new Solution();
        int m = 5;
        int n = 3;
        int maxForm = solution.findMaxForm(strs, m, n);
        System.out.println(maxForm);


    }
}
