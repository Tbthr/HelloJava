package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 669 👎 0

import java.util.*;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();
        private final List<Integer> list = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
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