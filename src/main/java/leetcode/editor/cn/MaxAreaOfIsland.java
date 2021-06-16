package leetcode.editor.cn;

//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 466 👎 0

import java.util.Stack;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0, 1}, {1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] direction = new int[]{-1, 0, 1, 0, -1};

        // 3. 栈
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = m > 0 ? grid[0].length : 0;
            int res = 0, local = 0, x, y;
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        local = 1;
                        grid[i][j] = 0;
                        stack.push(new int[]{i, j});
                        while (!stack.isEmpty()) {
                            int[] ints = stack.pop();
                            for (int k = 0; k < 4; k++) {
                                x = ints[0] + direction[k];
                                y = ints[1] + direction[k + 1];
                                if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                                    local++;
                                    grid[x][y] = 0;
                                    stack.push(new int[]{x, y});
                                }
                            }
                        }
                        res = Math.max(res, local);
                    }
                }
            }
            return res;
        }

        // 1. 递归写法 one
        /*public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = m > 0 ? grid[0].length : 0;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        public int dfs(int[][] a, int i, int j) {
            if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 0) {
                return 0;
            }
            a[i][j] = 0;
            return 1 + dfs(a, i + 1, j) + dfs(a, i, j - 1) + dfs(a, i - 1, j) + dfs(a, i, j + 1);
        }*/

        // 2. 递归写法 two
        /*public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = m > 0 ? grid[0].length : 0;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }
            return res;
        }

        public int dfs(int[][] a, int i, int j) {
            if (a[i][j] == 0) return 0;
            a[i][j] = 0;
            int cnt = 1, x, y;
            for (int k = 0; k < 4; k++) {
                x = i + direction[k];
                y = j + direction[k + 1];
                if (x >= 0 && x < a.length && y >= 0 && y < a[0].length) {
                    cnt += dfs(a, x, y);
                }
            }
            return cnt;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}