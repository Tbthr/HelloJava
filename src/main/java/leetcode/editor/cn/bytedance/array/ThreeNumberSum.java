package leetcode.editor.cn.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        Solution solution = new ThreeNumberSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    class Solution {
        // 排序 + 双指针
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, r = len - 1;
                int target = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] < target) {
                        l++;
                    } else if (nums[l] + nums[r] > target) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
            return res;
        }

        // 暴力解法，超时
        public List<List<Integer>> force_threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            for (int k = j + 1; k < nums.length; k++) {
                                if (k == j + 1 || nums[k] != nums[k - 1]) {
                                    if (nums[i] + nums[j] + nums[k] == 0) {
                                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
