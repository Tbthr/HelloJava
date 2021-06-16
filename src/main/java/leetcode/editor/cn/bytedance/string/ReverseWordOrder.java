package leetcode.editor.cn.bytedance.string;

import java.util.ArrayList;
import java.util.List;

// 翻转单词顺序
public class ReverseWordOrder {
    public static void main(String[] args) {
        Solution solution = new ReverseWordOrder().new Solution();
        System.out.println(solution.reverseWords1("   a   d   swefrrf    ew3rw   "));
    }

    class Solution {
        // 利用split函数分割字符串
        public String reverseWords1(String s) {
            String[] strings = s.trim().split(" ");
//            for (String string : strings) {
//                System.out.println("===" + string + "===");
//            }
            StringBuilder stringBuilder = new StringBuilder();
            String t;
            for (int i = strings.length - 1; i >= 0; i--) {
                t = strings[i];
                if ("".equals(t)) continue;
                stringBuilder.append(t);
                if (i > 0) stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        // 用list记录每个单词在s中的位置
        public String reverseWords2(String s) {
            char[] arr = s.toCharArray();
            List<int[]> list = new ArrayList<>();
            int sta, end;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') {
                    sta = i;
                    while (i <= arr.length - 1 && arr[i] != ' ') i++;
                    end = i;
                    list.add(new int[]{sta, end});
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                int[] ints = list.get(i);
                stringBuilder.append(s, ints[0], ints[1]);
                if (i > 0) stringBuilder.append(' ');
            }
            return stringBuilder.toString();
        }

        // 双指针，寻找单词，存入StringBuilder
        public String reverseWords3(String s) {
            s = s.trim(); // 删除首尾空格
            int j = s.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
                res.append(s, i + 1, j + 1).append(" "); // 添加单词
                while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
                j = i; // j 指向下个单词的尾字符
            }
            return res.toString().trim(); // 转化为字符串并返回
        }
    }
}
