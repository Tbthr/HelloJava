package programming;

public class PackageClass {
    public static void main(String[] args) {
        int i1 = 127;
        int i2 = 127;
        Integer i3 = 127;
        Integer i4 = 127;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i1 == i3);

        // Integer chenmo = new Integer(10);  // 手动装箱
        // int wanger = chenmo.intValue();  // 手动拆箱
        //Java SE5 为了减少开发人员的工作，提供了自动装箱与自动拆箱的功能。
        // Integer chenmo  = 10;  // 自动装箱
        // int wanger = chenmo;     // 自动拆箱
        //上面这段代码使用 JAD 反编译后的结果如下所示：
        // Integer chenmo = Integer.valueOf(10);
        // int wanger = chenmo.intValue(); 

        System.out.println("-----------------------");

        double d1 = 2.0;
        double d2 = 2.0;
        Double d3 = 2.0;
        Double d4 = 2.0;
        System.out.println(d1 == d2);
        System.out.println(d3 == d4);
        System.out.println(d1 == d4);

        System.out.println("-----------------------");

        float f1 = 2;
        float f2 = 2;
        Float f3 = 2f;
        Float f4 = 2f;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        System.out.println(f1 == f4);

        System.out.println("-----------------------");

        Object o = true ? new Integer(1) : new Double(1.0);
        System.out.println(o); // 1 1.0 null
    }
}