package programming.load;

public class Test {
    static {
        i = 10;
//        System.out.println(i);
    }

    static int i;

//    private int a = b;
//    private int b = a;

    public static void main(String[] args) {
        System.out.println(i);
    }
}

/* Output: 
        10
*/