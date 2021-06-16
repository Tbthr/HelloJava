package programming.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassConstructor {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        Class c1 = Class.forName("programming.reflection.Person");

        //获取类的名字
        System.out.println(c1.getName());  //programming.reflection.Person
        System.out.println(c1.getSimpleName());  //Person

        //获得类的属性
        Field[] fields = c1.getFields();  //只能找到public属性
        System.out.println("fields = " + Arrays.toString(fields)); // 输出：[]

        fields = c1.getDeclaredFields();  //找到全部属性
        for (Field field : fields) {
            System.out.println(field); //java.lang.String programming.reflection.Person.name
        }

        //获得指定属性
        Field name = c1.getDeclaredField("name");
        System.out.println("name = " + name);

        //获取类的方法
        Method[] methods = c1.getMethods();  //获取本类及其父类全部的public方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
        methods = c1.getDeclaredMethods();  //获取本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclareMethods:" + method);
        }

        //获得指定的方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获取构造器
        Constructor[] constructors = c1.getConstructors();  //获取指定的构造器
        for (Constructor constructor : constructors) {
            System.out.println("public的构造器：" + constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("全部构造器：" + constructor);
        }

        //获取指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class);
        System.out.println("指定构造器：" + declaredConstructor);
    }
}