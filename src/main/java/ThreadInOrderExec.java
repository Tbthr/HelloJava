
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInOrderExec {
    public static void main(String[] args) throws InterruptedException {
        final String next = "[1,3,2]";
        String[] orders = next.substring(1, next.length() - 1).split(",");
        FooPrint foo = new FooPrint();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
        for (int i = 0; i < orders.length; i++) {
            threads.get(Integer.parseInt(orders[i]) - 1).start();
        }
    }
}

class FooPrint {

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private volatile int number = 1; // 1A  2B  3C

    public FooPrint() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                conditionA.await();
            }
            new Thread(printFirst).start();
            number = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                conditionB.await();
            }
            new Thread(printSecond).start();
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                conditionC.await();
            }
            new Thread(printThird).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
