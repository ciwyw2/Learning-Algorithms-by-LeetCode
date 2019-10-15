public class Solution2 {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        if (len == 0) {
            return 0;
        }
        int res = 0;
        while (len > 0 && s.charAt(len - 1) != ' ') {
            res++;
            len--;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a ";
        Solution2 solution2 = new Solution2();
        int lengthOfLastWord = solution2.lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}
