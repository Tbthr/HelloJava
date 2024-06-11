/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节
 * 点，返回 反转后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * Related Topics链表
 * <p>
 * 👍 1794, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:反转链表 II
class ReverseLinkedListIi {
  public static void main(String[] args) {
    Solution solution = new ReverseLinkedListIi().new Solution();
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      // base case, 反转前 N 个节点
      if (left == 1) {
        return reverseN(head, right);
      }
      // 递归，将区间一直前移，直到 hit base case
      head.next = reverseBetween(head.next, left - 1, right - 1);
      return head;
    }

    // 记录反转链表的后一个节点
    private ListNode successorNode = null;
    private ListNode reverseN(ListNode head, int n) {
      if (head == null) {
        return null;
      }

      // base case
      if (n == 1) {
        successorNode = head.next;
        return head;
      }

      // 反转头节点后面的 n-1 个节点
      ListNode last = reverseN(head.next, n - 1);

      // 串起来
      head.next.next = head;
      head.next = successorNode;

      return last;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}