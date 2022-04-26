package programming.classLoad.class_path;

public class ResourceTest {

    public static void main(String[] args) {
        // 1、通过Class的getResource方法
        String a1 = ResourceTest.class.getResource("/programming/classLoad/class_path/ResourceTest.class").getPath();
        String a2 = ResourceTest.class.getResource("ResourceTest.class").getPath();
        String a3 = ResourceTest.class.getResource("/application.properties").getPath();
        String a4 = ResourceTest.class.getResource("").getPath();
        String a5 = ResourceTest.class.getResource("/").getPath();

        // 2、通过本类的ClassLoader的getResource方法
        String b1 = ResourceTest.class.getClassLoader().getResource("programming/classLoad/class_path/ResourceTest.class").getPath();
        String b2 = ResourceTest.class.getClassLoader().getResource("application.properties").getPath();
        String b3 = ResourceTest.class.getClassLoader().getResource("").getPath();
        Object b4 = ResourceTest.class.getClassLoader().getResource("/");

        // 3、通过ClassLoader的getSystemResource方法
        String c1 = ClassLoader.getSystemClassLoader().getResource("programming/classLoad/class_path/ResourceTest.class").getPath();
        String c2 = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        String c3 = ClassLoader.getSystemClassLoader().getResource("").getPath();
        Object c4 = ClassLoader.getSystemClassLoader().getResource("/");

        // 4、通过ClassLoader的getSystemResource方法
        String d1 = ClassLoader.getSystemResource("programming/classLoad/class_path/ResourceTest.class").getPath();
        String d2 = ClassLoader.getSystemResource("application.properties").getPath();
        String d3 = ClassLoader.getSystemResource("").getPath();
        Object d4 = ClassLoader.getSystemResource("/");

        // 5、通过Thread方式
        String e1 = Thread.currentThread().getContextClassLoader().getResource("programming/classLoad/class_path/ResourceTest.class").getPath();
        String e2 = Thread.currentThread().getContextClassLoader().getResource("application.properties").getPath();
        String e3 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Object e4 = Thread.currentThread().getContextClassLoader().getResource("/");


        System.out.println("start:");
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
        System.out.println("a4 = " + a4);
        System.out.println("a5 = " + a5);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);
        System.out.println("d4 = " + d4);
        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("end.");
    }
}