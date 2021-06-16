//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 124 👎 0


package leetcode.editor.cn.others;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口的最大值
public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null) return new int[0];
            if (nums.length == 0 || k == 1) return nums;
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
                if (i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst();
                while (!deque.isEmpty() && deque.peekLast() < nums[j])
                    deque.removeLast();
                deque.addLast(nums[j]);
                if (i >= 0) res[i] = deque.peekFirst();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}