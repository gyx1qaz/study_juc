package com.yx.thread_yield;


/**
 * 让出CPU执行权的yield方法
 *
 *
 * Thread类中有一个静态的yield方法，当一个线程调用yield方法时，实际就是在暗示线程调度器当前线程请求让出自己的CPU使用，
 * 但是线程调度器可以无条件忽略这个暗示。我们知道操作系统是为每个线程分配一个时间片来占有CPU的，正常情况下当一个线程把
 * 分配给自己的时间片使用完后，线程调度器才会进行下一轮的线程调度，而当一个线程调用了Thread类的静态方法yield时，是在告
 * 诉线程调度器自己占有的时间片中还没有使用完的部分自己不想使用了，这暗示线程调度器现在就可以进行下一轮的线程调度。
 * 当一个线程调用yield方法时，当前线程会让出CPU使用权，然后处于就绪状态，线程调度器会从线程就绪队列里面获取一个线程优先级最高的线程，
 * 当然也有可能会调度到刚刚让出CPU的那个线程来获取CPU执行权.
 *
 * 使用场景：
 *         在调试或者测试时这个方法或许可以帮助复现由于并发竞争条件导致的问题。
 */
public class yiedl_01 implements Runnable {
    yiedl_01() {
        // 创建线程
        Thread t = new Thread(this);
        System.out.println(this);
        t.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // 当i=0时 让出CPU 的执行权，放弃时间片段，进行下一轮调度。
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + " yield cpu ...");
                // 当前线程让出cpu执行权，放弃时间片段，进行下一轮调度，
                 Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+ " is over !");
    }

    public static void main(String[] args) {
        new yiedl_01();
        new yiedl_01();

        new yiedl_01();
    }

}
