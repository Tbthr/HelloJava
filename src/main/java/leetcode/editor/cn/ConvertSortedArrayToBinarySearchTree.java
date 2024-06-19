/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 按 严格递增 顺序排列
 * <p>
 * <p>
 * Related Topics树 | 二叉搜索树 | 数组 | 分治 | 二叉树
 * <p>
 * 👍 1524, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:将有序数组转换为二叉搜索树
class ConvertSortedArrayToBinarySearchTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
      if (l > r) {
        return null;
      }

      if (l == r) {
        return new TreeNode(nums[l]);
      }

      int mid = (l + r) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      TreeNode left = buildBST(nums, l, mid - 1);
      TreeNode right = buildBST(nums, mid + 1, r);
      root.left = left;
      root.right = right;
      return root;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}