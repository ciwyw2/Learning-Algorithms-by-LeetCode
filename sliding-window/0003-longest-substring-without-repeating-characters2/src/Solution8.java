/**
 * @author liweiwei1419
 * @date 2019/10/12 2:31 下午
 */
public class Solution8 {

    /**
     * 滑动窗口的优化
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 重复元素上一次出现的位置很重要
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] window = new int[128];
        for (int i = 0; i < 128; i++) {
            window[i] = -1;
        }

        int res = 1;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (window[s.charAt(i)] != -1) {
                left = Math.max(left, window[s.charAt(i)] + 1);
            }
            res = Math.max(res, i - left + 1);
            window[s.charAt(i)] = i;
        }
        return res;
    }
}
