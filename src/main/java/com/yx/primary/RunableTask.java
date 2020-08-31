package com.yx.primary;


/**
 * 两个线程共用一个task代码逻辑，如果需要，
 * 可以给RunableTask添加参数进行任务区分；
 *
 * 缺点：任务没有返回值。
 */
public class RunableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("I am a child thread");
    }

    public static void main(String[] args) throws InterruptedException {
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }


}
