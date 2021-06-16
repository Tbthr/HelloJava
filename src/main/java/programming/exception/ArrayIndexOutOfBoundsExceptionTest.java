package programming.exception;

public class ArrayIndexOutOfBoundsExceptionTest {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(arr[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("这是个异常，不是错误");
            }
        }
    }
}
