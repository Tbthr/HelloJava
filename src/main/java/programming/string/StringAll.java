package programming.string;

public class StringAll {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String(new char[]{'a', 'b', 'c'});
        String s4 = "test";
        String s5 = "abctest";
        String s6 = new String("abc") + new String("test");
        String s7 = s1 + "test";
        String s8 = "abc" + s4;
        String s9 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s9); // 除此之外，其他为 false
        System.out.println(s2 == s3);
        System.out.println(s2 == s9);
        System.out.println(s3 == s9);

        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s5 == s8);
        System.out.println(s6 == s7);
        System.out.println(s6 == s8);
        System.out.println(s7 == s8);
    }
}
