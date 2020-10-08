package com.yx.thread_interrupt;


// 在实例1上继续深研
public class Interrupt_02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("thread awaking !");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrputed while sleeping ");
                    return;
                }
                System.out.println("thread -leaving normally");
            }
        });
        // 启动线程
        thread.start();
        // 确保子线程进入休眠状态
        Thread.sleep(1000);
        // 打断子线程的休眠，让子线程从sleep函数返回
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();

        System.out.println("main thread is over ！ ");

    }
}
