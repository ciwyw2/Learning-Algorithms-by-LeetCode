public class Solution4 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                // 从 mid 到 right 都是顺序数组
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // 其余的情况就在右边了
                    right = mid - 1;
                }
            } else {
                // 此时 left 到 mid 是顺序数组
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 3;
        Solution4 solution4 = new Solution4();
        int search = solution4.search(nums, target);
        System.out.println(search);
    }

}
