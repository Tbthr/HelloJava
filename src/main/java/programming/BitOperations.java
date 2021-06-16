package programming;

public class BitOperations {
    private static int j = 0;

    private static boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i > 10 | methodB(4); //任何情况都会判断左右
        b = i < 10 || methodB(8); //左为真，右就不再判断
    }

    public static void main(String[] args) {
        methodA(0);
        System.out.println(j);
    }
}
