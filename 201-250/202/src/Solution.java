import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/happy-number/description/
public class Solution {

    // 一步一步如何得到这个整数的每个数位上的数字，可以通过下面的例子来思考
    // 132 % 10 = 2 *
    // 132 / 10 = 13

    // 13 % 10 = 3 *
    // 13 / 10 = 1

    // 1 % 10 = 1 *
    // 1 / 10 = 0

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        int remainder; // 当前模 10 的余数
        while (true) {
            sum = 0; // 重置当前求和
            while (n != 0) {
                remainder = n % 10; // 得到余数
                sum += remainder * remainder; // 不停地计算余数的平方之和
                n = n / 10;
            }
            // System.out.println("看我是如何变化的 " + sum);
            if (sum == 1) {
                return true;
            } else {// sum!=1
                if (set.contains(sum)) {
                    // 如果出现了和以前计算一样的结果，就说明这个过程会无限循环下去，所以一定不是 happy number
                    return false;
                } else {
                    n = sum;
                    set.add(sum);
                }
            }
        }
    }

    public static void main(String[] args) {
        // write your code here

        boolean happy = new Solution().isHappy(19);
        System.out.println(happy);
    }
}