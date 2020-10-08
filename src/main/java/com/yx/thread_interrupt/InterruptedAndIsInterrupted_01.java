package com.yx.thread_interrupt;


/**
 * 比较这两个函数
 */

public class InterruptedAndIsInterrupted_01 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;; ) {

                }
            }
        });

        // 启动线程
        thread.start();
        // 设置中断标志
        thread.interrupt();

        // 获取中断标志
        System.out.println("isInterrrupted :" +  thread.isInterrupted());

        System.out.println("isInterrrupted :" +  thread.interrupted());

        System.out.println("isInterrrupted :" +  thread.interrupted());

        System.out.println("isInterrrupted :" +  thread.isInterrupted());

        thread.join();

        System.out.println("main thread is over !");

    }

}
