package leetcode.editor.cn;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 978 👎 0

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1.快速选择
        /*public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSort(int[] a, int l, int r, int index) {
            int idx = partition(a, l, r);
            if (idx == index) {
                return a[idx];
            } else {
                return idx < index ? quickSort(a, idx + 1, r, index) : quickSort(a, l, idx - 1, index);
            }
        }

        public int partition(int[] a, int l, int r) {
            int mark = a[r], idx = l;
            for (int i = l; i < r; i++) {
                if (a[i] < mark) {
                    swap(a, i, idx++);
                }
            }
            swap(a, idx, r);
            return idx;
        }*/

        // 2.堆排序
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            buildMaxHeap(nums, n);
            for (int i = 1; i < k; i++) {
                swap(nums, 0, n - 1);
                n--;
                adjust(nums, 0, n);
            }
            return nums[0];
        }

        public void buildMaxHeap(int[] a, int len) {
            for (int i = len / 2; i >= 0; i--) {
                adjust(a, i, len);
            }
        }

        public void adjust(int[] a, int idx, int len) {
            int l = idx * 2 + 1, r = idx * 2 + 2, largest = idx;
            if (l < len && a[l] > a[largest]) {
                largest = l;
            }
            if (r < len && a[r] > a[largest]) {
                largest = r;
            }
            if (largest != idx) {
                swap(a, idx, largest);
                adjust(a, largest, len);
            }
        }

        public void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}