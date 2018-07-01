import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 和 Solution2 一样
 */
public class Solution3 {

    private void helper(int[] nums, int begin, int len, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            stack.add(nums[i]);
            helper(nums, i + 1, len, stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        helper(nums, 0, len, stack, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution3 solution3 = new Solution3();
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        List<List<Integer>> subsets = solution3.subsets(nums);
        System.out.println(subsets);
    }
}
