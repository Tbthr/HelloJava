package leetcode.editor.cn.bytedance.string;

// 最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        Solution solution1 = new LongestCommonPrefix().new Solution();
        System.out.println(solution1.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    // 横向对比：每每对比两个字符串获得前缀，再利用前缀去比对下一个字符串，为""提前结束
    class Solution {
        public String compare(String s1, String s2) {
            // 获取最小的长度
            int minLen = Math.min(s1.length(), s2.length());
            int index = 0;
            // 确保不越界，获取最长前缀
            while (index < minLen && s1.charAt(index) == s2.charAt(index))
                index++;
            return s1.substring(0, index);
        }

        public String longestCommonPrefix(String[] strs) {
            // 判断特殊条件
            if (strs == null || strs.length == 0) return "";

            String prefix = strs[0];
            // 两两比对
            for (int i = 1; i < strs.length; i++) {
                prefix = compare(prefix, strs[i]);
                if ("".equals(prefix)) break;
            }
            return prefix;
        }
    }

    // 纵向对比：依次对比第n个字符，遇到不符合的直接返回上一次成功的比对字符位置
    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            // 判断特殊条件
            if (strs == null || strs.length == 0) return "";

            int len = strs[0].length(); // 以第一个字符串为基准
            int cnt = strs.length; // 字符数组个数
            for (int i = 0; i < len; i++) { // 从第一个字符开始，纵向比对
                char c = strs[0].charAt(i);
                for (int j = 1; j < cnt; j++) {
                    // 当strs[0]更长时，就需要第一个判断条件来确保不越界，并提前结束
                    // 当前长度的比对中，若有一个字符串不符，直接返回上一个长度的结果
                    if (strs[j].length() == i || strs[j].charAt(i) != c)
                        return strs[0].substring(0, i);
                }
            }
            return strs[0]; // 全部比对符合条件，返回基准字符串
        }
    }
}
