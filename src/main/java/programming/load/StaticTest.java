package programming.load;

public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static { //静态代码块
        System.out.println("1");
    }

    { // 实例代码块
        System.out.println("2");
    }

    StaticTest() { // 实例构造器
        System.out.println("3");
        System.out.println("a = " + a + ",b = " + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
        System.out.println("b = " + b);
    }

    int a = 110; // 实例变量
    static int b = 112; // 静态变量
}
/* Output: 
        2
        3
        a=110,b=0
        1
        4
        b = 112
*/