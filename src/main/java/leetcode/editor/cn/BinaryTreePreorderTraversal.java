/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Related Topics栈 | 树 | 深度优先搜索 | 二叉树
 * <p>
 * 👍 1253, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//java:二叉树的前序遍历
class BinaryTreePreorderTraversal {
  public static void main(String[] args) {
    Solution solution = new BinaryTreePreorderTraversal().new Solution();
  }

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


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<Integer> res = new ArrayList<>();
// 1
//    public List<Integer> preorderTraversal(TreeNode root) {
//      if (root == null) {
//        return res;
//      }
//      traverse(root);
//      return res;
//    }
//
//    private void traverse(TreeNode t) {
//      if (t == null) {
//        return;
//      }
//      res.add(t.val);
//      traverse(t.left);
//      traverse(t.right);
//    }

// 2
//    public List<Integer> preorderTraversal(TreeNode root) {
//      if (root == null) {
//        return res;
//      }
//
//      ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//      TreeNode p = root;
//      while (p != null || !stack.isEmpty()) {
//        // 把左节点一路PUSH
//        while (p != null) {
//          // 入栈前就输出，即为前序遍历
//          res.add(p.val);
//
//          stack.push(p);
//          p = p.left;
//        }
//        // 如果当前节点没有左节点，则将PUSH效果作用给右节点
//        if (!stack.isEmpty()) {
//          TreeNode pop = stack.pop();
//          p = pop.right;
//        }
//      }
//
//      return res;
//    }

// 3
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) {
        return res;
      }

      ArrayDeque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode pop = stack.pop();
        res.add(pop.val);

        if (pop.right != null) {
          stack.push(pop.right);
        }
        if (pop.left != null) {
          stack.push(pop.left);
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}