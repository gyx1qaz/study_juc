package com.yx.primary;


/**
 * @since 2020/08/
 * @author yx
 * @discribtion learn java concurrent util
 * @note 创建完thread对象以后该线程并没有被启动执行
 *      直到调用了start方法后才启动了线程。
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
