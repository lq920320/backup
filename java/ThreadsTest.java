package myzd;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuqian
 * @date 2019/2/15 13:39
 * 参考文章：https://www.tutorialdocs.com/article/java-inter-thread-communication.html
 */
public class ThreadsTest {

  public static void main(String[] args) {
//    demo1();
//    demo2();
//    demo3();
//    runDAfterABC();
    runABCWhenAllReady();
  }

  private static void demo1() {
    Thread A = new Thread(() -> printNumber("A"));
    Thread B = new Thread(() -> printNumber("B"));
    A.start();
    B.start();
  }

  private static void demo2() {
    Thread A = new Thread(() -> printNumber("A"));
    Thread B = new Thread(() -> {
      System.out.println("B starts waiting for A.");
      try {
        A.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      printNumber("B");
    });
    B.start();
    A.start();
  }

  private static void demo3() {
    Object lock = new Object();
    Thread A = new Thread(() -> {
      System.out.println("INFO: A 等待锁");
      synchronized (lock) {
        System.out.println("INFO: A 得到了锁 lock");
        System.out.println("A 1");
        try {
          System.out.println("INFO: A 准备进入等待状态，调用 lock.wait() 放弃锁 lock 的控制权");
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("INFO: 有人唤醒了 A, A 重新获得锁 lock");
        System.out.println("A 2");
        System.out.println("A 3");
      }
    });
    Thread B = new Thread(() -> {
      System.out.println("INFO: B 等待锁");
      synchronized (lock) {
        System.out.println("INFO: B 得到了锁 lock");
        System.out.println("B 1");
        System.out.println("B 2");
        System.out.println("B 3");
        System.out.println("INFO: B 打印完毕，调用 lock.notify() 方法");
        lock.notify();
      }
    });
    A.start();
    B.start();
  }

  private static void printNumber(String threadName) {
    int i = 0;
    while (i++ < 3) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(threadName + " print: " + i);
    }
  }


  private static void runDAfterABC() {
    int worker = 3;
    CountDownLatch countDownLatch = new CountDownLatch(worker);
    new Thread(() -> {
      System.out.println("D is waiting for other three threads.");
      try {
        countDownLatch.await();
        System.out.println("All done, D starts working.");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    for (char threadName = 'A'; threadName <= 'C'; threadName++) {
      final String tN = String.valueOf(threadName);
      new Thread(() -> {
        System.out.println(tN + " is working.");
        try {
          Thread.sleep(100);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println(tN + " finished.");
        countDownLatch.countDown();
      }).start();
    }
  }

  private static void runABCWhenAllReady() {
    int runner = 3;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
    final Random random = new Random();
    for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
      final String rN = String.valueOf(runnerName);
      new Thread(() -> {
        long prepareTime = random.nextInt(10000) + 100;
        System.out.println(rN + " is preparing for time: " + prepareTime);
        try {
          Thread.sleep(prepareTime);
        } catch (Exception e) {
          e.printStackTrace();
        }
        try {
          System.out.println(rN + " is prepared, waiting for others.");
          cyclicBarrier.await(); // The current runner is ready, waiting for others to be ready
        } catch (InterruptedException | BrokenBarrierException e) {
          e.printStackTrace();
        }
        System.out.println(rN + " starts running.");   // All the runners are ready to start running together
      }).start();
    }
  }
}
