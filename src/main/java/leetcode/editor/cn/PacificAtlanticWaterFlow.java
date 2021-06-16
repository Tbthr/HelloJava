package leetcode.editor.cn;

//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 222 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] directions = new int[]{-1, 0, 1, 0, -1};
        int[][] heights;
        int m, n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> res = new ArrayList<>();
            m = heights.length;
            n = m > 0 ? heights[0].length : 0;
            this.heights = heights;
            boolean[][] canReachP = new boolean[m][n];
            boolean[][] canReachA = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(i, 0, canReachP);
                dfs(i, n - 1, canReachA);
            }
            for (int i = 0; i < n; i++) {
                dfs(0, i, canReachP);
                dfs(m - 1, i, canReachA);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachA[i][j] && canReachP[i][j])
                        res.add(Arrays.asList(i, j));
                }
            }
            return res;
        }

        public void dfs(int i, int j, boolean[][] canReach) {
            if (canReach[i][j]) return;
            canReach[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + directions[k];
                int y = j + directions[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && heights[i][j] <= heights[x][y]) {
                    dfs(x, y, canReach);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}