/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重
 * 构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序
 * 列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法
 * 解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
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
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中结点数在范围 [0, 10⁴] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树
 * <p>
 * 👍 1224, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

//java:二叉树的序列化与反序列化
class SerializeAndDeserializeBinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
  }
  //leetcode submit region begin(Prohibit modification and deletion)


  public class Codec {
    StringBuilder str = new StringBuilder();
    final String NULL = "#";
    final String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      traverse(root);
      return str.toString();
    }

    private void traverse(TreeNode root) {
      if (root == null) {
        str.append(NULL).append(SPLIT);
        return;
      }
      str.append(root.val).append(SPLIT);
      traverse(root.left);
      traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
        return null;
      }
      LinkedList<String> nodes = Arrays.stream(data.split(SPLIT)).collect(Collectors.toCollection(LinkedList::new));
      return build(nodes);
    }

    private TreeNode build(LinkedList<String> nodes) {
      if (nodes.isEmpty()) {
        return null;
      }

      String first = nodes.removeFirst();
      if (first.equals(NULL)) {
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(first));
      root.left = build(nodes);
      root.right = build(nodes);
      return root;
    }
  }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}