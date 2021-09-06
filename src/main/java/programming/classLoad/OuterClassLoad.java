package programming.classLoad;

public class OuterClassLoad {

    static {
        System.out.println("外部类加载");
    }

    public static void say() {
        System.out.println("外部类说");
    }

    static class InnerClass {
        static {
            System.out.println("内部类加载");
        }

        public static void say() {
            System.out.println("内部类说");
        }
    }

    public static void main(String[] args) {
        InnerClass.say();
    }
}