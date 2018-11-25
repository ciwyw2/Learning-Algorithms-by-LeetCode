import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    // https://leetcode-cn.com/problems/binary-tree-paths/description/
    // 257. 二叉树的所有路径
    // 使用递归求解就可以完成
    // 在以 node 为根节点的二叉树中，得到一个到叶子节点的路径，pre 表示走到 node 沿途的路径

    private void binaryTreePath(TreeNode node, String pre, List<String> res) {
        // 递归终止条件：走到根节点的时候，就可以把沿途积累的字符串添加到结果集中
        if (node.left == null && node.right == null) {
            res.add(pre + node.val);
            return;
        }
        if (node.left != null) {
            binaryTreePath(node.left, pre + node.val + "->", res);
        }
        if (node.right != null) {
            binaryTreePath(node.right, pre + node.val + "->", res);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // 将全局的结果保存在这里
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        binaryTreePath(root, "", res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        Solution solution = new Solution();
        List<String> binaryTreePaths = solution.binaryTreePaths(node1);
        binaryTreePaths.forEach(System.out::println);
    }
}