package programming.thread;

import java.util.concurrent.*;

public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRunnable!");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() {
            System.out.println("Hello MyCallable!");
            return "success";
        }
    }

    //启动线程的5种方式
    public static void main(String[] args) {

        new MyThread().start();

        new Thread(new MyRun()).start();

        new Thread(() -> System.out.println("Hello Lambda!")).start();

        /*
        与使用Runnable相比， Callable功能更强大些：
            相比run()方法，可以有返回值
            方法可以抛出异常
            支持泛型的返回值
            需要借助FutureTask类，比如获取返回结果
        Future接口：
        	可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等
        	FutureTask 是Future接口的唯一的实现类
        	FutureTask 同时实现了Runnable, Future接口
        	它既可以作为 Runnable被线程执行，又可以作为Future得到Callable的返回值
        */
        FutureTask<String> futureTask = new FutureTask<>(new MyCall());
        Thread t = new Thread(futureTask);
        t.start();
        try {
            // 获取Callable实现类中的call返回值
            String value = futureTask.get();
            System.out.println("返回值为：" + value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /*
        使用线程池 ：
            提前创建好多个线程，放入线程池中，使用时直接获取，使用完 放回池中。可以避免频繁创建销毁、实现重复利用
            提高响应速度（减少了创建新线程的时间）
            降低资源消耗（重复利用线程池中线程，不需要每次都创建）
            便于线程管理：
                corePoolSize：核心池的大小
                maximumPoolSize：最大线程数
                keepAliveTime：线程没有任务时最多保持多长时间后会终止
        线程池相关API ：
        	JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors
        	ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
                 void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行 Runnable
                 <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行 Callable
                 void shutdown() ：关闭连接池
        	Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
                 Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
                 Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
                 Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
                 Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或定期执行
        */

        // 1.调用Executors的newFixedThreadPool(int n),返回指定线程数量的ExecutorService
        ExecutorService service = Executors.newFixedThreadPool(1);
        // 2.将Runnable实现类的对象作为形参传递给ExecutorService的execute()方法中，开启线程
        service.execute(() -> System.out.println("Hello ThreadPool"));
        // 3.结束线程的使用
        service.shutdown();
    }
}