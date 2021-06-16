package programming.reflection;

public class LoaderTest {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用，父类没被引用，会先加载它的父类
        Son son = new Son();

        //反射也会产生，主动引用
        Class.forName("programming.reflection.Son");

        //子类引用父类的静态方法或者变量，并不会让子类加载
        System.out.println(Son.b);

        //这是一个名字和一片空间而已，并不会加载类
        Son[] sons = new Son[8];

        //常量并不会引起父类和子类的初始化 常量在链接阶段就存入常量池中了
        System.out.println(Son.M);
    }
}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {

    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}