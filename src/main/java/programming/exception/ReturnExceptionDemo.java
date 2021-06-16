package programming.exception;

public class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("调用A方法的finally");
        }
    }

    static int methodB() {
        try {
            System.out.println("进入方法B");
            throw new Exception();
//            return 1;
        } catch (Exception e) {
            return 3;
        } finally {
            System.out.println("调用B方法的finally");
            return 2;
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) { //多个catch，父类在下面，范围由小到大
            System.out.println(e.getMessage());
        }
        int i = methodB();
        System.out.println(i);
    }
}
