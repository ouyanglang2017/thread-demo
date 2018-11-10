package com.startai.demos;

import java.util.concurrent.Callable;

/**
 * 使用Callable和Future接口创建线程
 */
public class CallableFutureDemo implements Callable<Integer> {

    //与run方法不同的是，call方法有返回值
    public Integer call() throws Exception {
        int i=0;
        for (;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //捕获异常后使用break来退出循环
                e.printStackTrace();
               break;
            }
            System.out.println(Thread.currentThread().getName()+"   "+ i);
        }
        return i;
    }
}
