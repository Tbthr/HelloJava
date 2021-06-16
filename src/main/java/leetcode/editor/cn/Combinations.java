package leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 553 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) return res;
            Deque<Integer> queue = new ArrayDeque<>();
            dfs(res, 1, k, queue, n);
            return res;
        }

        public void dfs(List<List<Integer>> res, int idx, int k, Deque<Integer> queue, int n) {
            if (queue.size() == k) {
                res.add(new ArrayList<>(queue));
                return;
            }
            for (int i = idx; i <= n - (k - queue.size()) + 1; i++) {
                queue.addLast(i);
                dfs(res, i + 1, k, queue, n);
                queue.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}