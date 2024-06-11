/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * <p>
 * Related Topics递归 | 链表 | 数学
 * <p>
 * 👍 10623, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:两数相加
class AddTwoNumbers {
  public static void main(String[] args) {
    Solution solution = new AddTwoNumbers().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
        return null;
      } else if (l1 == null) {
        return l2;
      } else if (l2 == null) {
        return l1;
      } else {
        int tempVal = 0;
        ListNode head1 = l1, head2 = l2;
        while (l1.next != null && l2.next != null) {
          tempVal = l1.val + l2.val + tempVal;
          l1.val = l2.val = tempVal % 10;
          tempVal /= 10;

          l1 = l1.next;
          l2 = l2.next;
        }

        ListNode res = l1.next == null ? head2 : head1;
        // 当前节点还没计算，从当前节点开始处理
        ListNode left = l1.next == null ? l2 : l1;
        // 处理短链的最后一个节点，暂存到 tempVal 中
        tempVal += left == l1 ? l2.val : l1.val;
        // 处理长链
        while (tempVal != 0 && left.next != null) {
          tempVal += left.val;
          left.val = tempVal % 10;
          tempVal /= 10;
          left = left.next;
        }
        // 长链不够了，但 tempVal 仍然有值
        if (left.next == null) {
          // 1. 处理当前节点
          tempVal += left.val;
          left.val = tempVal % 10;
          // 2. 如果 tempVal 还有值，需要增加一个节点
          if ((tempVal = (tempVal / 10)) != 0) {
            left.next = new ListNode(tempVal);
          }
        }
        return res;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}