package programming.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    //AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题

    // 正常在业务操作，这里面都是一个业务对象，而在这里为了简便演示，用了Integer，注意其缓存问题
    // new AtomicStampedReference<>(初始值,初始时间戳or版本号)
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1000);

    // CAS  compareAndSet : 比较并交换！
    public static void main(String[] args) {

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("a1=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " +
                    atomicStampedReference.compareAndSet(1,
                            1000,
                            atomicStampedReference.getStamp(),
                            atomicStampedReference.getStamp() + 1));

            System.out.println("a2=>" + atomicStampedReference.getStamp());

            System.out.println(Thread.currentThread().getName() + " " +
                    atomicStampedReference.compareAndSet(1000,
                            1,
                            atomicStampedReference.getStamp(),
                            atomicStampedReference.getStamp() + 1));

            System.out.println("a3=>" + atomicStampedReference.getStamp());

        }, "a").start();


        // 乐观锁的原理相同！
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("b1=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " +
                    atomicStampedReference.compareAndSet(1,
                            1000,
                            stamp,
                            stamp + 1));
            System.out.println("b2=>" + atomicStampedReference.getStamp());

        }, "b").start();
    }
}