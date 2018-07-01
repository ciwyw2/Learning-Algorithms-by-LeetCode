import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 思路同 Solution2 只不过更清晰一些
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        // 为了避免重复多次的情况，这里使用 Set 去除重复
        HashSet<String> repeated = new HashSet<>();

        int len = s.length();
        int begin = 0;
        int end = 10;

        StringBuilder stringBuilder = new StringBuilder(s);
        // 注意这里是等于号，因为 substring 方法的第 2 个参数是开区间的右端点，取不到
        while (end <= len) {
            String segment = stringBuilder.substring(begin, end);
            if (seen.contains(segment)) {
                repeated.add(segment);
            } else {
                seen.add(segment);
            }
            begin++;
            end++;
        }
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution solution = new Solution();
        List<String> repeatedDnaSequences = solution.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }
}
