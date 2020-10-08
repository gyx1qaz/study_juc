package com.yx.await_notify;


/**
 * 等待线程执行终止的join方法
 *
 * 使用场景：
 *         在项目实践中经常会遇到一个场景，就是需要等待某几件事情完成后才能继续往下执行，
 *         比如多个线程加载资源，需要等待多个线程全部加载完毕再汇总处理
 */
public class join_01 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne Over! ");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" child threadTwo over ！");
            }
        });

        // 启动子线程
        threadOne.start();
        threadTwo.start();
        System.out.println("wait all child thread over !");
        // 等待子线程执行完毕返回

        threadOne.join();
        threadTwo.join();

        System.out.println("all child thread over !");
    }
}
