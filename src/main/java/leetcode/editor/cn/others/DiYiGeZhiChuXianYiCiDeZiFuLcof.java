//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 49 👎 0


package leetcode.editor.cn.others;

//Java：第一个只出现一次的字符
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            int[] t = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                t[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < len; i++) {
                if (t[s.charAt(i) - 'a'] == 1) return s.charAt(i);
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}