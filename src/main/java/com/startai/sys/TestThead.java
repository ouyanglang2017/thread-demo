package com.startai.sys;

import com.startai.demos.CallableFutureDemo;
import com.startai.demos.RunnableDemo;
import com.startai.demos.TheadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThead {
    public static void main(String[]args) throws InterruptedException {
//       Thread thread =new TheadDemo();
//       thread.setName("线程1");
//       thread.start();
//
//        Thread thread2 =new TheadDemo();
//        thread2.setName("线程2");
//        thread2.start();
        //实现Runnable接口重写run方法的方式新建一个线程
//        Thread thread = new Thread(new RunnableDemo(),"线程1");
//        thread.start();
//       Thread thread = new TheadDemo();
//       thread.setName("线程2");
//       thread.start();

        Callable<Integer> callable = new  CallableFutureDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask);
        thread.setName("线程3");
        thread.start();
        Thread.sleep(6000);
        thread.interrupt();

    }
}
