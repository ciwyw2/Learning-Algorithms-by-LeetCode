/**
 * @author liweiwei1419
 * @date 2019/9/20 12:07 下午
 */
public class Solution2 {
    /**
     * 暴力解法：固定了起点
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
