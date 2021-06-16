package programming.exception;

public class TryReturn {

    public static int test(int x, int y) {
        int result = x;
        try {
            if (x < 0 || y < 0) {
                return 0;
            }
            result = x + y;
            return result;
        } finally {
            result = x - y;
            System.out.println(result);
//            return result; // 返回值为-2
        }
    }

    public static void main(String[] args) {
        int test = test(3, 5);
        System.out.println(test);
    }
}
