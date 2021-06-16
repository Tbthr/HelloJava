package programming.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NewClassByReflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("programming.reflection.Person");

        //构造一个对象  此调用必须要有默认构造函数
        Person person1 = (Person) c1.newInstance();
        System.out.println(person1);  //调用默认构造方法

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class);
        Person person2 = (Person) constructor.newInstance("test");
        System.out.println(person2);

        //通过反射调用普通方法
        Person person3 = (Person) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke : 激活的意思(对象,[方法的值])
        setName.invoke(person3, "liu");
        System.out.println(person3.getName());

        //通过反射操作属性
        Person person4 = (Person) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，关闭安全检测，暴力反射可以提高效率
        name.setAccessible(true);
        name.set(person4, "li");
        System.out.println(person4.getName());
    }
}