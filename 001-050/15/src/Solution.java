import java.util.*;
// https://leetcode-cn.com/problems/3sum/description/
public class Solution {

    private class Triad {
        private int a;
        private int b;
        private int c;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triad triad = (Triad) o;
            return a == triad.a &&
                    b == triad.b &&
                    c == triad.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        Set<Triad> resultSet = new HashSet<>();
        Triad curSolution;
        Set<Integer> set = new HashSet<>();
        int target;
        for (int i = 0; i < nums.length - 2; i++) {
            target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (!set.contains(target - nums[j])) {
                    set.add(nums[j]);
                } else {
                    // 找到了一个解
                    curSolution = new Triad();
                    curSolution.a = -target; // 这里要极其小心
                    curSolution.b = target - nums[j];
                    curSolution.c = nums[j];
                    resultSet.add(curSolution);
                }
            }
            set.clear();
        }

        List<Integer> oneSolution;
        for (Triad t : resultSet) {
            oneSolution = new ArrayList<>();
            oneSolution.add(t.a);
            oneSolution.add(t.b);
            oneSolution.add(t.c);
            result.add(oneSolution);
        }
        return result;
    }


    // https://leetcode-cn.com/problems/3sum/description/
    public static void main(String[] args) {
        // write your code here
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);

    }
}