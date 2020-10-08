package com.yx.thread_sleep;


/**
 * 当一个线程处于睡眠状态时，如果另外一个线程中断了它，
 * 会不会在调用sleep方法处抛出异常
 *
 *
 * 子线程在睡眠期间，主线程中断了它，所以子线程在调用sleep方法处抛出了InterruptedException异常。
 */
public interface sleepStudy_02 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" child thread is in sleep");
                try {
                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 启动线程
        thread.start();
        //主线程休眠1秒
        Thread.sleep(1000);
        // 主线程中断子线程
        thread.interrupt();

    }
}
