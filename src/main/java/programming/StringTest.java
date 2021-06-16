package programming;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);

        String str = "中";
        try {
            System.out.println(str.getBytes("ISO8859-1").length);// -128~127
            System.out.println(str.getBytes("GBK").length); //中文用2位存
            System.out.println(str.getBytes(StandardCharsets.UTF_8).length); //中文用3位存
            System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));// 乱码，表示不了中文
            System.out.println(new String(str.getBytes("GBK"), "GBK"));
            System.out.println(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("==============================");

        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
        System.out.println("==============================");

        String s = null;
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());// 0
        sb.append(s);
        System.out.println(sb.length());// append，如果是null的String，则添加"null”，扩容4
        System.out.println(sb);
        // StringBuffer sb1 = new StringBuffer(s);// 不能传 null的String
        // System.out.println(sb1);
        System.out.println("===================================");

        String a = "aaabaaabaaac";
        System.out.println(a.replace("aaa", "b"));
        System.out.println(a.replace("a", "b"));
        System.out.println(a.indexOf("a", -1));// fromIndex<0则从0开始找
        System.out.println("=======================");

        char chars[][] = new char[2][2];
        chars[0][0] = 97;
        chars[0][1] = 98;
        chars[1][0] = 99;
        chars[1][1] = 100;
        System.out.println(Arrays.deepToString(chars));

        String[] c = {"p", "e", "o", "p", "l", "e"};
        String t = "people";
        System.out.println(t.equals(c));//false
    }
}