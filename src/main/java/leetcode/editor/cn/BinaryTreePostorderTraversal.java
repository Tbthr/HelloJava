/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Related Topics栈 | 树 | 深度优先搜索 | 二叉树
 * <p>
 * 👍 1178, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//java:二叉树的后序遍历
class BinaryTreePostorderTraversal {
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
    Solution solution = new BinaryTreePostorderTraversal().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<Integer> res = new ArrayList<>();

//    private void traverse(TreeNode node) {
//      if (node == null) return;
//      traverse(node.left);
//      traverse(node.right);
//      res.add(node.val);
//    }
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//      if (root == null) return res;
//      traverse(root);
//      return res;
//    }


    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    public List<Integer> postorderTraversal(TreeNode root) {
      if (root == null) return res;

      // 记录上一个遍历完的子树根节点
      TreeNode visited = new TreeNode(-1);

      // 开始遍历
      traverseLeftTree(root);

      while (!stack.isEmpty()) {
        TreeNode node = stack.peek();

        // node 的左子树已经遍历完了，但右子树还没遍历
        if ((node.left == null || node.left == visited) && node.right != visited) {
          traverseLeftTree(node.right);
        }

        // node 的右子树遍历完了，即 node 的子树都遍历完了，更新 visited，并将其从栈中弹出，去处理 node 的父节点及其右子树
        if (node.right == null || node.right == visited) {
          res.add(node.val);
          visited = node;

          stack.pop();
        }
      }

      return res;
    }

    private void traverseLeftTree(TreeNode p) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}