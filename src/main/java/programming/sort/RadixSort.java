package programming.sort;

import java.util.Arrays;

public class RadixSort {

    // 返回 最大的数有多少个十进制的位数
    public static int getMaxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int bits = 0;
        while (max != 0) {
            bits++;
            max /= 10;
        }
        return bits;
    }

    // 返回 x 在 d 位上的数（1234在第2位上的数为3）
    public static int getDigit(int x, int d) {
        return (x / (int) Math.pow(10, d - 1)) % 10;
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1, getMaxBits(arr));
    }

    // digit 表示最大的数有多少个十进制的位数
    public static void sort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i, j;
        // 有多少个数，就准备多大的辅助空间
        int[] buckets = new int[R - L + 1];
        // 最大的数有多少位，就进行多少次操作
        for (int d = 1; d <= digit; d++) {
            // 每一位上的数都是0~9（保存出现的次数）
            int[] countArr = new int[radix];
            // 计算次数
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                countArr[j]++;
            }
            // 转换为对应数上的排名
            for (i = 1; i < radix; i++) {
                countArr[i] += countArr[i - 1];
            }
            // 从后往前遍历，根据排名插入buckets对应的位置
            for (i = R; i >= 0; i--) {
                j = getDigit(arr[i], d);
                buckets[countArr[j] - 1] = arr[i];
                countArr[j]--;
            }
            // 更新数据
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = buckets[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {110, 72, 25, 44, 7, 62, 3, 4, 235, 1, 812, 9, 19};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
