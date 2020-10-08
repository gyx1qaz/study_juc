package com.yx.thread_lock;

public class Lock_01 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        // 创建线程A

        Thread threadA =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "getResourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting get resourceB");
                }

                synchronized (resourceB) {
                    System.out.println(Thread.currentThread()+"getResourceB");
                }
            }
        });
            // 创建线程B
            Thread threadB = new Thread(new Runnable() {
                @Override
                public void run() {

                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "getResourceB");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread() + "waiting get ResourceA");
                    }
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get ResourceA");
                    }
                }
            });

            // 启动线程
            threadA.start();
            threadB.start();

    }
}
