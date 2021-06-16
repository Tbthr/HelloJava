//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 487 👎 0

package leetcode.editor.cn.others;

//Java：平衡二叉树
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        // TO TEST
        System.out.println(solution.isBalanced(null));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // public boolean isBalanced(TreeNode root) {
        //     if (root == null) return true;
        //     return Math.abs(hight(root.left) - hight(root.right)) <= 1
        //             && isBalanced(root.left) && isBalanced(root.right);
        // }
        //
        // public int hight(TreeNode node) {
        //     if (node == null) return 0;
        //     return Math.max(hight(node.left), hight(node.right)) + 1;
        // }

        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }

        public int recur(TreeNode node) {
            if (node == null) return 0;
            int left = recur(node.left);
            if (left == -1) return -1;
            int right = recur(node.right);
            if (right == -1) return -1;
            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}