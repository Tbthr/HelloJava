package leetcode.editor.cn.bytedance.string;

import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串
public class OldestNoDuplicateCharacters {
    public static void main(String[] args) {
        Solution solution = new OldestNoDuplicateCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int size = s.length();
            if (size == 0) return 0;
            Set<Character> set = new HashSet<>();
            int rk = -1, ans = 0; // -1表示右指针在字符前，未开始；ans存结果
            for (int i = 0; i < size; i++) { // 左指针
                if (i != 0) {
                    // 从第二个字符开头计算的时候，移除开头前一个字符，确保set中仅保留当前所计算字符
                    set.remove(s.charAt(i - 1));
                }
                // 确保不越界，不重复，右指针无限右移，并将过程中的字符存入set中
                while (rk + 1 < size && !set.contains(s.charAt(rk + 1))) {
                    set.add(s.charAt(rk + 1));
                    ++rk;
                }
                ans = Math.max(ans, rk - i + 1); // 取最大长度
            }
            return ans;
        }
    }
}
