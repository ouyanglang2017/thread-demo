package com.startai.queue;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class OutThread extends Thread {

    private LinkedBlockingQueue<Map<String, Object>> queue = MessageQueue.getQueue();

    @Override
    public void run() {
        while (true){
            Map<String, Object> map = null;
            try {
                map = queue.take();
                if (map!=null){
                    System.out.println("开始从队列里面拿消息...");
                    System.out.println("拿到一条消息...");
                    //遍历消息
                    String topic = "";
                    Object object = null;
                    for (String key : map.keySet()) {
                        topic = key;
                        object = map.get(key);
                    }
                    //遍历完了之后就可以做消息发送
                    System.out.println("消息发送："+topic+"    "+object);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
