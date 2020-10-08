package com.yx.await_notify;


/**
 * 在1基础上演进
 *
 */
public class join_02 {
    public static void main(String[] args) {
         // 线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for (; ; ) {

                }
            }
        });

        // 获取主线程
       final Thread mainThread = Thread.currentThread();
        // 线程Two

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断线程
                mainThread.interrupt();
            }
        });


        // 启动子线程
        threadOne.start();
        // 延迟1s 启动线程
        threadTwo.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread :" +e);
        }
    }
}
