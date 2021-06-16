package leetcode.editor.cn.bytedance.string;

import java.util.*;

// 字符串的排列组合
public class PermutationList {
    public static void main(String[] args) {
        Solution solution = new PermutationList().new Solution();
        System.out.println(Arrays.toString(solution.permutation("ccab")));
    }

    class Solution {
        ArrayList<String> list = new ArrayList<>();
        char[] c;

        public void swap(int i, int j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }

        public void dfs(int x) {
            if (x == c.length - 1) {
                list.add(String.valueOf(c)); // 添加排列方案
                return;
            }
            Set<Character> set = new HashSet<>();
            for (int i = x; i < c.length; i++) {
                if (set.contains(c[i])) continue; // 重复，剪枝
                set.add(c[i]);
                swap(i, x); // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1); // 开启固定第 x + 1 位字符
                swap(i, x); // 恢复交换
            }
        }

        public String[] permutation(String s) {
            if (s != null && s.length() > 0) {
                c = s.toCharArray();
                dfs(0); // 从第0位开始固定
                Collections.sort(list); // 如果要求顺序排列
            }
            return list.toArray(new String[0]);
        }
    }
}
