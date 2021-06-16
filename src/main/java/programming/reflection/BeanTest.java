package programming.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BeanTest {

    public static void main(String[] args) {

        // 初始化Bean1
        Bean1 bean1 = new BeanTest().new Bean1();
        bean1.I++;
        System.out.println("初始化Bean1：" + bean1.I);
        // 反射产生非静态内部类Bean1的实例化对象
        try {
            Class<?> bean1Class = Class.forName("programming.reflection.BeanTest$Bean1");
            // Bean1 b6 = (Bean1) bean1Class.newInstance();
            // 报错java.lang.NoSuchMethodException: programming.reflection.Test$Bean1.<init>()
            // System.out.println(b6);
            Constructor<?>[] c = bean1Class.getDeclaredConstructors();
            int i = c[0].getModifiers(); //得到访问修饰符
            System.out.println("Bean1默认构造器的访问修饰符为：" + i);
            for (Constructor<?> constructor : c) {
                System.out.println("Bean1构造器：" + constructor);
            }

            Bean1 bean11 = (Bean1) c[0].newInstance(new BeanTest()); //非静态内部类第一个参数需要传递一个外部类对象
            bean11.I += 666;
            System.out.println("反射生成的非静态内部类Bean1属性I输出：" + bean11.I);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 初始化Bean2
        Bean2 bean2 = new Bean2();
        bean2.J++;
        System.out.println("初始化Bean2：" + bean2.J);
        // 反射产生静态内部类Bean2的实例化对象
        try {
            Class<?> bean2Class = Class.forName("programming.reflection.BeanTest$Bean2");
            Bean2 bean22 = (Bean2) bean2Class.newInstance(); //静态内部类不需要传递外部对象、成功生成实例化对象
            bean22.J += 777;
            System.out.println("反射生成的静态内部类Bean2属性J输出：" + bean22.J);

            Bean2 bean222 = (Bean2) bean2Class.getDeclaredConstructor().newInstance();
            bean222.J += 7777;
            System.out.println("反射生成的静态内部类Bean2属性J输出：" + bean222.J);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
            e1.printStackTrace();
        }

        //初始化Bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.K++;
        System.out.println("初始化Bean3：" + bean3.K);
        // 反射产生外部类Bean的非静态内部类Bean2的实例化对象
        try {
            Class<?> clazz = Class.forName("programming.reflection.Bean$Bean3");
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            Bean.Bean3 bean33 = (Bean.Bean3) declaredConstructors[0].newInstance(new Bean());
            bean33.K += 888;
            System.out.println("反射产生外部类Bean的非静态内部类Bean2的实例化对象属性K输出：" + bean33.K);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    class Bean1 {
        public int I = 0;
    }

    static class Bean2 {
        public int J = 0;
    }
}