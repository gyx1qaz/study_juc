package com.yx.thread_sleep;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  深入理解sleep()？监视器资源与CPU资源。
 *
 *  sleep 静态方法只是让出CPU 的竞争权，但是并没有释放锁的。
 *
 *  线程在睡眠时拥有的监视器资源不会被释放
 */
public class sleepStudy_01 {


    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 创建线程ThreadA
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child treadB is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        });


        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child threadB is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
    }
}
