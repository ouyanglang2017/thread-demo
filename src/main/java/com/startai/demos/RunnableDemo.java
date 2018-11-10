package com.startai.demos;

/**
 * 实现Runnable接口重写run方法的方式新建一个线程
 */
public class RunnableDemo implements  Runnable {
    public volatile  boolean exit = false;

    public void run() {

        int i =0;
        while (!exit){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   "+i);
            i++;
            if (i>10){
                exit =true;
            }
        }

    }

}
