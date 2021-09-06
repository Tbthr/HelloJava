package programming.classLoad;

public class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SClass extends SSClass {
    static {
        System.out.println("SClass init!");
    }

    public static int value = 123;

    public SClass() {
        System.out.println("init SClass");
    }
}

class SubClass extends SClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}

class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
        SClass[] sca = new SClass[10];
    }
}

/* Output: 
        SSClass
        SClass init!
        123     
 */