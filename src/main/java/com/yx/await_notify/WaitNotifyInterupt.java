package com.yx.await_notify;


/**
 * 当一个线程调用共享对象的wait（）方法被阻塞挂起后，如果其他线程中断了该线程，
 * 则该线程会抛出InterruptedException异常并返回。
 */
public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("___begin____");
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("___end____");
                }catch (InterruptedException e){
                        e.printStackTrace();
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);

        System.out.println("__begin_interrupt__threadA_____");
        threadA.interrupt();
        System.out.println("____end_interrupt_threadA _____");
    }
}
