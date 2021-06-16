package programming.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("programming.reflection.User");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            //找到了外面的注解 @programming.reflection.TableTemp("db_stu")
            System.out.println(annotation);
        }

        //获得注解value的值：db_stu
        TableTemp tableTemp = c1.getAnnotation(TableTemp.class);
        String value = tableTemp.value();
        System.out.println(value);

        Field f = c1.getDeclaredField("name");  //name对应表中的字段
        FieldTemp annotation = f.getAnnotation(FieldTemp.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
        /*
         * 获得类指定的注解
         * db_name
         * String
         * 10
         */
    }
}

@TableTemp("db_stu")
class User {
    @FieldTemp(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldTemp(columnName = "db_name", type = "String", length = 10)
    private String name;
    @FieldTemp(columnName = "db_age", type = "varchar", length = 5)
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

@Target(ElementType.TYPE) //设置作用域
@Retention(RetentionPolicy.RUNTIME)
        //设置什么级别可以获取
@interface TableTemp {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldTemp {
    String columnName(); //列名的注解

    String type(); //类型

    int length(); //长度
}