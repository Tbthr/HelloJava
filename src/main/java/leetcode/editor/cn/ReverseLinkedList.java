/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * Related Topics递归 | 链表
 * <p>
 * 👍 3595, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:反转链表
class ReverseLinkedList {
  public static void main(String[] args) {
    Solution solution = new ReverseLinkedList().new Solution();
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
    // 1. 递归
    public ListNode reverseList1(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode last = reverseList(head.next);

      head.next.next = head;
      head.next = null;
      return last;
    }

    // 2. 迭代
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode pre = null, curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
      }
      return pre;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}