package programming.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GenericTest {

    public void test01(Map<String, Person> map, List<Person> list) {
        System.out.println("test01");
    }

    public Map<String, Person> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //加载的方法和参数
        Method method = GenericTest.class.getMethod("test01", Map.class, List.class);
        //获得泛型的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type type : genericParameterTypes) {  //打印泛型
            System.out.println("#" + type);
            if (type instanceof ParameterizedType) {  //想知道里面的参数类型
                //强转获得真实的泛型参数信息
                Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type temp : typeArguments) {
                    System.out.println(temp);
                }
            }
        }
        /*
        #java.util.Map<java.lang.String, programming.reflection.Person>
        class java.lang.String
        class programming.reflection.Person
        #java.util.List<programming.reflection.Person>
        class programming.reflection.Person
        */

        method = GenericTest.class.getMethod("test02", null);
        //获得返回值泛型
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type temp : types) {
                System.out.println(temp);
            }
        }
        /*
        class java.lang.String
        class programming.reflection.Person
        */
    }
}