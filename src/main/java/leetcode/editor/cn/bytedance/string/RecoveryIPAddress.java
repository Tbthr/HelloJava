package leetcode.editor.cn.bytedance.string;

import java.util.ArrayList;
import java.util.List;

// 复原IP地址
public class RecoveryIPAddress {
    public static void main(String[] args) {
        Solution solution = new RecoveryIPAddress().new Solution();
        System.out.println(solution.restoreIpAddresses("101023"));
    }

    // 递归
    class Solution {
        static final int SEG_COUNT = 4;
        List<String> ans = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 0);
            return ans;
        }

        public void dfs(String s, int segId, int segStart) {
            // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
            if (segId == SEG_COUNT) {
                if (segStart == s.length()) {
                    StringBuilder ipAddr = new StringBuilder();
                    for (int i = 0; i < SEG_COUNT; ++i) {
                        ipAddr.append(segments[i]);
                        if (i != SEG_COUNT - 1) {
                            ipAddr.append('.');
                        }
                    }
                    ans.add(ipAddr.toString());
                }
                return;
            }

            // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
            if (segStart == s.length()) {
                return;
            }

            // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
            if (s.charAt(segStart) == '0') {
                segments[segId] = 0;
                dfs(s, segId + 1, segStart + 1);
                // return; 对应 addr > 0 ，二选一
            }

            // 一般情况，枚举每一种可能性并递归
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                // addr == 0的话，说明是从(s.charAt(segStart) == '0')的回调，不符合条件
                // 或者直接在(s.charAt(segStart) == '0')末尾加上 return，直接返回上一级
                if (addr > 0 && addr <= 0xFF) {
                    segments[segId] = addr;
                    dfs(s, segId + 1, segEnd + 1);
                } else {
                    break;
                }
            }
        }
    }

    // 暴力解法
    class Solution1 {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            StringBuilder ip = new StringBuilder();

            // 4层循环，3 x 4 = 12，IP地址由4个整数组成，0<=每个整数<=255，因此在本题中，s最长有12个字符
            for (int a = 1; a < 4; a++) {
                for (int b = 1; b < 4; b++) {
                    for (int c = 1; c < 4; c++) {
                        for (int d = 1; d < 4; d++) {
                            /*
                             * 1、保障下面subString不会越界
                             * 2、保障截取的字符串与输入字符串长度相同
                             * 3、不能保障截取的字符串转成int后与输入字符串长度相同
                             * 如：字符串010010，a=1，b=1，c=1，d=3，对应字符串0，1，0，010
                             *    转成int后seg1=0，seg2=1，seg3=0，seg4=10
                             * 所以需要下面的判断 if (ip.length() == s.length() + 3)
                             */
                            if (a + b + c + d == s.length()) {
                                int seg1 = Integer.parseInt(s.substring(0, a));
                                int seg2 = Integer.parseInt(s.substring(a, a + b));
                                int seg3 = Integer.parseInt(s.substring(a + b, a + b + c));
                                int seg4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                                // 四个段数值满足0~255
                                if (seg1 <= 255 && seg2 <= 255 && seg3 <= 255 && seg4 <= 255) {
                                    ip.append(seg1).append(".")
                                            .append(seg2).append(".")
                                            .append(seg3).append(".")
                                            .append(seg4);
                                    // 保障截取的字符串转成int后与输入字符串长度相同
                                    if (ip.length() == s.length() + 3) {
                                        result.add(ip.toString());
                                    }
                                    ip.delete(0, ip.length());
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}
