/**
 * https://leetcode-cn.com/problems/reverse-integer/description/
 * 要特别注意到反转以后整数越界的问题
 *
 * @author liwei
 */
public class Solution {

    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        long res = 0;
        x = sign * x;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        res = sign * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1534236469;
        int reverse = solution.reverse(x);
        System.out.println(reverse);
    }
}
