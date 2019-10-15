import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }

        Arrays.sort(nums);
        // [0,1,2,3] 4
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);

                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum > 0) {
                    // 后面的数太大了，让它往前走一步试试看
                    right--;
                } else {
                    // sum < 0， 前面的数太小了，让它往后走一步试试看
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        Solution solution3 = new Solution();
        List<List<Integer>> res = solution3.threeSum(nums);
        res.forEach(System.out::println);
    }
}
