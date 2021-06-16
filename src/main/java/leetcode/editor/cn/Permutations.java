package leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1285 👎 0

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();
        private final List<Integer> list = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            Arrays.stream(nums).forEach(list::add);
            System.out.println("list = " + list);
            dfs(0);
            return res;
        }

        public void dfs(int x) {
            if (x == list.size() - 1) {
                res.add(new ArrayList<>(list));
                return;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = x; i < list.size(); i++) {
                Integer t = list.get(i);
                if (set.contains(t)) continue;
                set.add(t);
                Collections.swap(list, x, i);
                dfs(x + 1);
                Collections.swap(list, x, i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}