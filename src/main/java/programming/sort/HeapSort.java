package programming.sort;

import java.util.Scanner;

public class HeapSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        buildHeap(arr); // 构建最大堆

        int len = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 交换堆顶元素与末位元素
            heapify(arr, 0, --len); // 将最大的元素踢出(排好序), 调整堆
        }
    }

    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    // 1.迭代写法
    public static void heapify(int[] arr, int index, int len) {
        int left = 2 * index + 1;
        while (left < len) { // 有左孩子
            // 值最大的孩子
            int bigChild = (left + 1 < len && arr[left + 1] > arr[left])
                    ? left + 1
                    : left;
            int largest = arr[bigChild] > arr[index] ? bigChild : index;
            if (largest == index) { // 最大元素是父亲, 无需调整
                break;
            }

            swap(arr, bigChild, index); // 调整

            // 更新index, 周而复始
            index = bigChild;
            left = 2 * index + 1;
        }
    }

    // 2.递归写法
    public static void sink(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            sink(arr, largest, len);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}