public class Solution4 {

    // 定义成频率数组，刘宇波老师给出的思路，使用滑动窗口的思路
    // 不是很好理解，可以供参考

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int[] freq = new int[128];
        int res = 1;

        int l = 0;
        int r = -1;

        // 只要左边不越界
        while (l < len) {
            // r + 1 最多到 len-1 表示没有越界
            // freq[s.charAt(r + 1)] == 0 表示下一个字母还没有出现过
            // 【这个分类标准是很关键的，r + 1 表示接下来要考察的索引位置，=0 表示在 [l,r] 这个区间里没有出现】
            if (r + 1 < len && freq[s.charAt(r + 1)] == 0) {
                // 右边第 1 个字母加入频率数组，频数 + 1
                freq[s.charAt(++r)]++;
            } else {
                // 如果下一个字符已经越界了，或者右边第 1 个字母是频率数组是曾经出现过的
                // 把左边从频数数组中挪掉，即频数减1
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String s = "abcabcbb";
        int lengthOfLongestSubstring = solution4.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
