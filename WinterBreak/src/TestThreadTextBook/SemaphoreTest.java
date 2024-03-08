package TestThreadTextBook;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/8 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class SemaphoreTest
{
    private static final Semaphore semaphore = new Semaphore(2); // 初始化Semaphore为2，允许同时有两个线程访问共享资源
    private static final Lock lock = new ReentrantLock(); // 初始化Lock

    public static void main(String[] args) {
        // 创建多个线程并启动
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Worker("Thread " + i));
            thread.start();
        }
    }

    static class Worker implements Runnable {
        private final String name;

        Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 获取Semaphore
                lock.lock(); // 获取Lock
                // 访问共享资源
                System.out.println(name + ": Accessing the shared resource");
                Thread.sleep(2000); // 模拟访问共享资源的耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放Lock
                semaphore.release(); // 释放Semaphore
            }
        }
    }
}
