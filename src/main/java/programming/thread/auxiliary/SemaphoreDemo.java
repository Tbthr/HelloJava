package programming.thread.auxiliary;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 抢车位！
// 6车---3个停车位置
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量：停车位! 限流！
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                // acquire() 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                    semaphore.release(); // release() 释放
                }
            }, String.valueOf(i)).start();
        }
    }
}