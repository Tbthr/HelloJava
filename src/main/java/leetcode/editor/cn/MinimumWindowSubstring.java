package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1038 👎 0

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] chars = new int[128];
            boolean[] flag = new boolean[128];
            for (int i = 0; i < t.length(); i++) {
                flag[t.charAt(i)] = true;
                ++chars[t.charAt(i)];
            }
            int cnt = 0, l = 0, min_l = 0, min_size = s.length() + 1;
            for (int r = 0; r < s.length(); r++) {
                if (flag[s.charAt(r)]) {
                    if (--chars[s.charAt(r)] >= 0) {
                        ++cnt;
                    }
                    while (cnt == t.length()) {
                        if (r - l + 1 < min_size) {
                            min_l = l;
                            min_size = r - l + 1;
                        }
                        if (flag[s.charAt(l)] && ++chars[s.charAt(l)] > 0) {
                            --cnt;
                        }
                        ++l;
                    }
                }
            }
            return min_size > s.length() ? "" : s.substring(min_l, min_l + min_size);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}