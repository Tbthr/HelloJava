package leetcode.editor.cn.bytedance.string;

// 字符串的排列：
// 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
public class StringArrangement {
    public static void main(String[] args) {
        Solution solution = new StringArrangement().new Solution();
        System.out.println(solution.checkInclusion("ab", "hbabe"));
    }

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length())
                return false;
            int[] s1map = new int[26];
            int[] s2map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1map[s1.charAt(i) - 'a']++;
                s2map[s2.charAt(i) - 'a']++;
            }
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (s1map[i] == s2map[i])
                    cnt++;
            }
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (cnt == 26)
                    return true;
                int l = s2.charAt(i) - 'a', r = s2.charAt(i + s1.length()) - 'a';
                s2map[l]--; // 窗口左侧减一，判断改变前后对cnt的影响
                if (s1map[l] == s2map[l])
                    cnt++;
                else if (s1map[l] == s2map[l] + 1)
                    cnt--;
                s2map[r]++; // 窗口右侧加一，判断改变前后对cnt的影响
                if (s1map[r] == s2map[r])
                    cnt++;
                else if (s1map[r] == s2map[r] - 1)
                    cnt--;
            }
            return cnt == 26;
        }
    }
}
