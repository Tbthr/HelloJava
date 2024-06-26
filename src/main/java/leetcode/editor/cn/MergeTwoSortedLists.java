/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * <p>
 * Related Topics递归 | 链表
 * <p>
 * 👍 3522, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */
package leetcode.editor.cn;

//java:合并两个有序链表
class MergeTwoSortedLists {
  public static void main(String[] args) {
    Solution solution = new MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null) {
        return list2;
      }

      if (list2 == null) {
        return list1;
      }

      ListNode l = new ListNode();
      ListNode res = l;
      while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
          l.next = list1;
          list1 = list1.next;
        } else {
          l.next = list2;
          list2 = list2.next;
        }
        l = l.next;
      }
      l.next = list1 == null ? list2 : list1;
      return res.next;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}