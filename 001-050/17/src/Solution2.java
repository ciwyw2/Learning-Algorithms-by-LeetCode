import java.util.ArrayList;
import java.util.List;

// 只是比上一版多了打印输出的语句
public class Solution2 {

    private List<String> result = new ArrayList<>();
    private String[] digitsMap = new String[]{
            " ", // 0
            "",  // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz"  // 9
    };
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.length() == 0) {
            return result;
        }
        findCombinations(0, "");
        return result;
    }

    private void findCombinations(int index, String pre) {
        if (index == digits.length()) {
            System.out.println("已经从根节点走到叶子节点，得到的一个组合是：" + pre);
            result.add(pre);
            return;
        }
        String currStr = digitsMap[digits.charAt(index) - '0'];
        for (int i = 0; i < currStr.length(); i++) {
            System.out.println("循环遍历中，当前的索引是：" + index + "，已经得到的字符串是：" + pre);
            findCombinations(index + 1, pre + currStr.charAt(i));
        }
        System.out.println("循环结束以后，当前的索引是：" + index + "，已经得到的字符串是：" + pre);
    }

    public static void main(String[] args) {
        List<String> result = new Solution2().letterCombinations("234");
        System.out.println(result);
    }
}
