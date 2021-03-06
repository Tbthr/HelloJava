package programming.thread.blocking_queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueue_Test {

    static SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                long starTime = System.currentTimeMillis();
                queue.put("java高并发系列，路人甲Java!");
                long endTime = System.currentTimeMillis();
                System.out.printf("[%s,%s,take耗时:%s],%s%n", starTime, endTime, (endTime - starTime), Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //休眠5秒之后，从队列中take一个元素
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() + " 调用take获取并移除元素, " + queue.take());
    }
}