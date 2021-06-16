package programming.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VolatileTest {

    private static int a = 0;
    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    a++;
                    try {
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            list.add(t);
        }

       Thread.sleep(3000);

        System.out.println("a = " + a);
    }
}
