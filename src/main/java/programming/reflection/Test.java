package programming.reflection;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("person.toString() = " + person.toString());
        System.out.println("这个人是: " + person.name);

        //1.通过对象获得
        Class<? extends Person> c1 = person.getClass();
        System.out.println("c1.hashCode() = " + c1.hashCode());

        //2.forName获得
        Class<?> c2 = Class.forName("programming.reflection.User");
        System.out.println("c2.hashCode() = " + c2.hashCode());

        //3.通过类名.class获得
        Class<User> c3 = User.class;
        System.out.println("c3.hashCode() = " + c3.hashCode());

        //4. 基本内置类型的包装类都有一个Type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println("c4.hashCode() = " + c4.hashCode());

        //5. 获得父类类型
        Class<?> c5 = c1.getSuperclass();
        System.out.println("c5.getSimpleName() = " + c5.getSimpleName());
    }
}

class Person {
    String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}