package com.yx.thread_interrupt;

public class InterruptedAndIsInterrupted_02 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 中断标志为True 时会推出循环，并且清除中断标志
                while (!Thread.currentThread().interrupted()) {

                }
                System.out.println("thread threadOne isInterruputed " + Thread.currentThread().isInterrupted());
            }
        });
        // 启动线程
        thread.start();

        thread.interrupt();
        thread.join();
        System.out.println("main thread is over !");

    }

}
