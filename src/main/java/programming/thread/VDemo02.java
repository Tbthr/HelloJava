package programming.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo02 {

    private volatile static int num = 0;
    // 原子类的 Integer
    private /*volatile*/ static AtomicInteger atomic_num = new AtomicInteger();

    public static void add() {
        num = num + 1; // 不是一个原子性操作
        atomic_num.getAndIncrement(); // AtomicInteger + 1 方法，CAS
    }

    public static void main(String[] args) {

        //理论上num结果应该为 2 万，实际却小于 2 万
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) { // main  gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
        System.out.println(Thread.currentThread().getName() + " " + atomic_num);
    }
}