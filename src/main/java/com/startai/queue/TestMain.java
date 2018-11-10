package com.startai.queue;



public class TestMain {


    public static void main(String[]args) throws InterruptedException {
        System.out.println("开启消息队列线程...");
        Thread thread  = new OutThread();
        thread.start();
        System.out.println("开启监控键盘输入线程...");
        Thread thread1 = new SysInThread();
        thread1.start();
        System.out.println("开启查询数据库线程...");
        Thread thread2 = new TimingQuery();
        thread2.start();
    }

}
