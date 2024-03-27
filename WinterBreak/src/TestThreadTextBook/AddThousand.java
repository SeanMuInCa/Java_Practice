package TestThreadTextBook;

import com.sun.tools.javac.Main;

/**
 * Purpose:             TestThreadTextBook<br />
 * Data Submitted:      2024/3/26 <br />
 * Assignment Number:    TestThreadTextBook<br />
 * Course Name:         COSC603  <br />
 * Instructor:          Michael Grzesina  <br />
 * File Path:          TestThreadTextBook <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class AddThousand {
    // 共享的数字
    private static int sharedNumber = 0;

    // 线程类
    static class IncrementThread extends Thread {
        @Override
        public void run() {
            // 每个线程都给共享的数字加1
            synchronized (Main.class) {
                sharedNumber++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建并启动1000个线程
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new IncrementThread();
            threads[i].start();
        }

        // 等待所有线程结束
        for (Thread thread : threads) {
            thread.join();
        }

        // 打印最终的结果
        System.out.println("Final number: " + sharedNumber);
    }
}
