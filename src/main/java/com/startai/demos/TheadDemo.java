package com.startai.demos;

/**
 * 继承Thread类重写run方法方式新建一个线程
 */
public class TheadDemo extends Thread {
    public volatile  int i = 0;

    @Override
    public void run() {
        for (;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   "+ i);
            if (i > 5){
                i = 20;
            }
        }
    }
}
