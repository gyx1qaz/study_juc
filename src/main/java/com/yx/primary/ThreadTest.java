package com.yx.primary;


/**
 * @since 2020/08/
 * @author yx
 * @discribtion learn java concurrent util
 * @note 创建完thread对象以后该线程并没有被启动执行
 *      直到调用了start方法后才启动了线程。
 *
 *  使用继承方式创建线程的好处是：
 *  ①在run() 方法内获取当前线程直接使用this就可以；
 *  ② Java 不支持多继承，不能继承其他的类；
 *  ③ 任务与代码没有分离，当多个线程执行一样的任务的时需要多份任务代码。
 *
 *  *****获取当前线程的方式：(继承则无需这么操作)
 *       Thread.currentThread();
 */
public class ThreadTest {
    //继承Thread 并重写run()方法
    public static class MyThread extends Thread
    {
        @Override
        public void run()
        {
            System.out.println(" I am a child thread");
        }
    }


    public static void main(String[] args)
    {
        // 创建线程
        MyThread thread = new MyThread();
        //启动线程
        thread.start();
    }
}
