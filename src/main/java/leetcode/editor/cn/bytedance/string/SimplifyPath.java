package leetcode.editor.cn.bytedance.string;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 简化路径，如：
// 输入："/a/../../b/../c//.//"
// 输出："/c"
public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/../"));
    }

    class Solution {
        public String simplifyPath(String path) {
            if (path == null || path.length() == 0) return path;

            Deque<String> deque = new LinkedList<>();
            String[] split = path.split("/");
            for (String s : split) {
                // 不处理 "" 和 "."
                if (!"".equals(s) && !".".equals(s)) {
                    if ("..".equals(s)) {
                        if (!deque.isEmpty()) deque.pollLast();
                    } else { // 处理目录字符串
                        deque.addLast(s);
                    }
                }
            }
            if (deque.isEmpty()) return "/"; // 队列为空，表示当前目录为根目录，直接返回
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append("/").append(s);
            }
            return sb.toString();
        }

        public String list_simplifyPath(String path) {
            if (path == null || path.length() == 0) return path;

            // 用list保存，分割后的字符串集合
            List<String> list = new ArrayList<>(path.length() / 2);
            String[] split = path.split("/");
            list.add("/"); // 首位置加入"/"
            for (String s : split) {
                if (!"".equals(s)) list.add(s);
            }
            if (list.size() == 1) return list.get(0); // path 只包含 "/"
            int idx = 1; // 指针从 1 开始向后遍历
            do {
                if (".".equals(list.get(idx))) {
                    list.remove(idx--);
                } else if ("..".equals(list.get(idx))) {
                    list.remove(idx);
                    // 确保不移除 "/"
                    if (idx - 1 > 0) list.remove(idx - 1);
                    idx -= 2;
                    // 确保不越界
                    if (idx < 0) idx = 0;
                } else {
                    idx++;
                }
            } while (idx != list.size());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i <= 1) sb.append(list.get(i));
                else sb.append("/").append(list.get(i));
            }
            return sb.toString();
        }
    }
}
