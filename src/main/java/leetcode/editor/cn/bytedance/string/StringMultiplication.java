package leetcode.editor.cn.bytedance.string;

// 字符串相乘
public class StringMultiplication {
    public static void main(String[] args) {
        Solution solution = new StringMultiplication().new Solution();
        System.out.println(solution.optimize_multiply("999", "999"));
    }

    class Solution {
        public String addString(String s1, String s2) {
            int l1 = s1.length() - 1, l2 = s2.length() - 1;
            int carry = 0;
            StringBuilder res = new StringBuilder();
            while (l1 >= 0 || l2 >= 0 || carry > 0) {
                int x = (l1 >= 0) ? s1.charAt(l1) - '0' : 0;
                int y = (l2 >= 0) ? s2.charAt(l2) - '0' : 0;
                int sum = x + y + carry;
                res.append(sum % 10);
                carry = sum / 10;
                l1--;
                l2--;
            }
            return res.reverse().toString();
        }

        // 字符串处理较为频繁
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";

            int l1 = num1.length(), l2 = num2.length();
            String res = "";
            for (int i = l2 - 1; i >= 0; i--) {
                StringBuilder curr = new StringBuilder();
                // 移位处理
                for (int j = l2 - 1; j > i; j--) {
                    curr.append("0");
                }
                int x = num2.charAt(i) - '0';
                int carry = 0;
                for (int j = l1 - 1; j >= 0; j--) {
                    int y = num1.charAt(j) - '0';
                    int sum = x * y + carry;
                    curr.append(sum % 10);
                    carry = sum / 10;
                }
                if (carry > 0) curr.append(carry);
                res = addString(res, curr.reverse().toString());
            }
            return res;
        }

        // 数组处理，并结合数学证明，优化算法
        public String optimize_multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";

            int l1 = num1.length(), l2 = num2.length();
            int[] ans = new int[l1 + l2];
            // 一定要从后开始计算，虽然两数位置(i,j)上的数字相乘的结果固定在ans[i+j+1]中
            // 如果从前开始计算，在运算过程中，ans[i+j]可能会 >=10，而后面的运算无法对此进行处理，导致计算错误
            for (int i = l1 - 1; i >= 0; i--) {
                for (int j = l2 - 1; j >= 0; j--) {
                    ans[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    ans[i + j] += ans[i + j + 1] / 10;
                    ans[i + j + 1] = ans[i + j + 1] % 10;
                }
            }
            int idx = ans[0] == 0 ? 1 : 0;
            StringBuilder res = new StringBuilder();
            for (int i = idx; i < ans.length; i++) {
                res.append(ans[i]);
            }
            return res.toString();
        }
    }
}
