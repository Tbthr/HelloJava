package leetcode.editor.cn.bytedance.string;

// 字符串相加
public class StringAddition {
    public static void main(String[] args) {
        Solution solution = new StringAddition().new Solution();
        System.out.println(solution.addStrings("123", "123"));
    }

    class Solution {
        // StringBuilder保存结果，反转返回
        public String addStrings(String num1, String num2) {
            int l1 = num1.length() - 1, l2 = num2.length() - 1;
            int carry = 0;
            StringBuilder res = new StringBuilder();
            while (l1 >= 0 || l2 >= 0) {
                int x = (l1 >= 0) ? num1.charAt(l1) - '0' : 0;
                int y = (l2 >= 0) ? num2.charAt(l2) - '0' : 0;
                int sum = x + y + carry;
                res.append(sum % 10);
                carry = sum / 10;
                l1--;
                l2--;
            }
            // 处理遗留进位
            if (carry > 0) res.append(carry);
            return res.reverse().toString();
        }
    }
}
