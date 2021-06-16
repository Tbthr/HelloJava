package programming.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        /* 
        线程池相关API：
        	JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors：
        	ExecutorService：真正的线程池接口（常见子类ThreadPoolExecutor）
                 <T> Future<T> submit(Runnable task,T result)：执行任务，没有返回值，一般用来执行Runnable
                 <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般用来执行Callable
                 void shutdown()：关闭连接池
        	Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
                 Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
                 Executors.newFixedThreadPool(n)：创建一个可重用固定线程数的线程池
                 Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池
                 Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或定期执行
        */
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程

        try {
            for (int i = 0; i < 100; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " ok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}