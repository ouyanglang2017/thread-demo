package com.startai.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class TimingQuery extends Thread{

    private LinkedBlockingQueue<Map<String, Object>> queue = MessageQueue.getQueue();

    @Override
    public void run() {
        int i =1;
        while (true){
            try {
                //假如隔10s查询一次数据库
                Thread.sleep(1000*10);
                Map<String, Object> map = new HashMap<String, Object>();
                System.out.println("第"+i+"次查询");
                map.put("次数",i);
                queue.put(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }


    }
}
