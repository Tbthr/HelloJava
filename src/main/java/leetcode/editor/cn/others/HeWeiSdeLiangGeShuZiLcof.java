//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 46 👎 0

package leetcode.editor.cn.others;

//Java：和为s的两个数字
public class HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
        // TO TEST
        int[] ints = solution.twoSum(new int[]{14, 15, 16, 22, 53, 60}, 76);
        for (int x : ints) {
            System.out.println(x);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // Map<Integer, Integer> map = new HashMap<>();
            // for (int num : nums) {
            //     map.put(num, 1);
            // }
            // int[] res = new int[2];
            // for (int num : nums) {
            //     if (map.get(target - num) != null) {
            //         res[0] = num;
            //         res[1] = target - num;
            //         return res;
            //     }
            // }
            // return res;

            int i = 0, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] > target) j--;
                else if (nums[i] + nums[j] < target) i++;
                else return new int[]{nums[i], nums[j]};
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}