package programming.sort;

public class QuickSort {
    private static void quickSort(int[] arr, int low, int high){
        int i,j,temp,t;
        if(low>=high){
            return;
        }
        i=low;
        j=high;
        //temp���ǻ�׼λ
        temp = arr[low];
        while (i<j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //������������򽻻�
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
        arr[low] = arr[j];
        arr[j] = temp;
        //�ݹ�����������
        quickSort(arr, low, i-1);
        //�ݹ�����Ұ�����
        quickSort(arr, i+1, high);
    }


    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}