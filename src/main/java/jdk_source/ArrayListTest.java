package jdk_source;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

    @Test
    public void copyOf() {
        String[] s = new String[]{"a", "b", "c"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(s));
        System.out.println("list = " + list);

        Object[] objects = list.toArray();
        System.out.println("objects = " + Arrays.toString(objects));
        // Object.java
        // public String toString() {
        //     return getClass().getName() + "@" + Integer.toHexString(hashCode());
        // }

        String[] strings1 = new String[0];
        String[] strings2 = new String[3];
        Object[] objects1 = list.toArray(strings1);
        Object[] objects2 = list.toArray(strings2);
        System.out.println("objects1 = " + Arrays.toString(objects1));
        System.out.println("strings1.hashCode() = " + strings1.hashCode());
        System.out.println("strings2.hashCode() = " + strings2.hashCode());
        System.out.println("objects1.hashCode() = " + objects1.hashCode());
        System.out.println("objects2.hashCode() = " + objects2.hashCode());
        // toArray(T [] a)
        // 如果传入的数组小于 size 大小，则直接复制一个新数组返回
        // 否则返回 a 本身

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(123);
        Integer[] integer = new Integer[]{1, 2, 3};
        Integer[] integers = arrayList.toArray(integer);
        System.out.println("integers = " + Arrays.toString(integers));
        // 如果传入的数组大于 size 大小，则将 size 赋值为 null
    }
}
