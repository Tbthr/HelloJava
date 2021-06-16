//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 156 👎 0

package leetcode.editor.cn.others;

import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int i = 1;
            int j = 1;
            int sum = 0;
            List<int[]> res = new ArrayList<>();
            while (i <= target / 2) {
                if (sum < target) {
                    sum += j;
                    j++;
                } else if (sum == target) {
                    int[] t = new int[j - i];
                    int x = 0;
                    for (int k = i; k < j; k++) {
                        t[x++] = k;
                    }
                    res.add(t);
                    sum -= (2 * i + 1);
                    i += 2;
                } else {
                    sum -= i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}