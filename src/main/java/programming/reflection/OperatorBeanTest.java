package programming.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class OperatorBeanTest {

    static class Example {
    }

    interface Operator {
        double func(double d1, double d2);
    }

    static class Add implements Operator {
        @Override
        public double func(double d1, double d2) {
            return d1 + d2;
        }
    }

    static class Sub implements Operator {
        @Override
        public double func(double d1, double d2) {
            return d1 - d2;
        }
    }

    static class SimpleFactory {
        public static Operator createInstance(String oper){
            Operator operator;
            switch (oper) {
                case "+" -> operator = new Add();
                case "-" -> operator = new Sub();
                default -> throw new IllegalStateException("Unexpected value: " + oper);
            }
            return operator;
        }
    }

    @Test
    public void task1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Example example = new Example();

        Class<Example> exampleClass = Example.class;// 1
        Class<?> aClass = Class.forName("programming.reflection.OperatorBeanTest$Example");// 2
        Class<? extends Example> aClass1 = example.getClass();// 3
        System.out.println(exampleClass == aClass);
        System.out.println(exampleClass == aClass1);

        Constructor<?>[] declaredConstructors = exampleClass.getDeclaredConstructors();
        Object o = declaredConstructors[0].newInstance();// 1

        Example example2 = exampleClass.newInstance();// 2 已过时
    }

    @Test
    public void task2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\programming\\reflection\\test.properties"));
        String operator = properties.getProperty("operator");
        Operator instance = SimpleFactory.createInstance(operator);
        System.out.println(instance.func(1, 1));
    }
}
