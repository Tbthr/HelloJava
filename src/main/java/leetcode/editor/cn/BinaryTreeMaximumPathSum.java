/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过
 * 根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目范围是 [1, 3 * 10⁴]
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树
 * <p>
 * 👍 2230, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:二叉树中的最大路径和
class BinaryTreeMaximumPathSum {
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
    Solution solution = new BinaryTreeMaximumPathSum().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
      maxPathToSelf(root);
      return res;
    }

    private int maxPathToSelf(TreeNode node) {
      if (node == null) {
        return 0;
      }

      // 左右子树的最大单边和，如果小于0，则舍弃
      int left = Math.max(maxPathToSelf(node.left), 0);
      int right = Math.max(maxPathToSelf(node.right), 0);

      // 更新 res
      res = Math.max(res, node.val + left + right);

      return node.val + Math.max(left, right);
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}