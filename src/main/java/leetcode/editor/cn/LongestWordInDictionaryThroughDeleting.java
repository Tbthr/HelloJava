package leetcode.editor.cn;

//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 135 👎 0

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            int max_size = 0, max_idx = -1;
            int len = s.length();
            for (int i = 0; i < dictionary.size(); i++) {
                String t = dictionary.get(i);
                if (t.length() < max_size || t.length() > len) continue;
                int j = 0, k = 0;
                while (j < len && k < t.length()) {
                    if (s.charAt(j) == t.charAt(k)) {
                        j++;
                        k++;
                    } else {
                        j++;
                    }
                }
                if (k >= t.length()) {
                    if (max_idx < 0 || t.length() > max_size || t.compareTo(dictionary.get(max_idx)) < 0) {
                        max_size = t.length();
                        max_idx = i;
                    }
                }
            }
            return max_idx < 0 ? "" : dictionary.get(max_idx);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}