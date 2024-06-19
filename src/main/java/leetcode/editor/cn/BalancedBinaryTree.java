/**
 * 给定一个二叉树，判断它是否是 平衡二叉树
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -10⁴ <= Node.val <= 10⁴
 * <p>
 * <p>
 * Related Topics树 | 深度优先搜索 | 二叉树
 * <p>
 * 👍 1518, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:平衡二叉树
class BalancedBinaryTree {
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
    Solution solution = new BalancedBinaryTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      }

      return height(root) >= 0;
    }

    private int height(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int left = height(root.left);
      int right = height(root.right);

      if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
        return -1;
      }

      return Math.max(left, right) + 1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}