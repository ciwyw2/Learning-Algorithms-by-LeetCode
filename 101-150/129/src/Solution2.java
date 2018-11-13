// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/description/


import java.util.ArrayList;
import java.util.List;

// 我的思路：这个写法，画个图就非常清晰了，抓住二叉树的特点

public class Solution2 {

    private int sumNumbers(TreeNode node, int cumsum) {
        if (node == null) {
            return 0;
        }
        cumsum = 10 * cumsum + node.val;
        if (node.left == null && node.right == null) {
            return cumsum;
        }
        return sumNumbers(node.left, cumsum) + sumNumbers(node.right, cumsum);
    }


    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        // write your code here
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        Solution2 solution2 = new Solution2();
        int result = solution2.sumNumbers(n1);
        System.out.println("得到的结果：" + result);
    }
}
