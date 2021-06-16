package leetcode.editor.cn;

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 334 👎 0

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            int cnt = 0;
            while (l <= r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                } else {
                    if (r - l == 1) return true;
                    else if (s.charAt(l + 1) == s.charAt(r) && s.charAt(l + 2) == s.charAt(r - 1)) {
                        l++;
                        if (++cnt > 1) return false;
                    } else if (s.charAt(r - 1) == s.charAt(l) && s.charAt(r - 2) == s.charAt(l + 1)) {
                        r--;
                        if (++cnt > 1) return false;
                    } else return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}