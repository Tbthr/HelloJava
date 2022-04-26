package programming.collection;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        ArraysTest o1 = new ArraysTest();
        ArraysTest o2 = new ArraysTest();
        ArraysTest o3 = new ArraysTest();
        Object[] objects = new Object[4];
        objects[0] = o1;
        objects[1] = o2;
        objects[2] = o3;
        System.out.println("Arrays.stream(objects) = " + Arrays.stream(objects));
        System.out.println("Arrays.stream(objects) = " + Arrays.stream(objects));

        System.out.println(Arrays.deepToString(objects));
    }
}
