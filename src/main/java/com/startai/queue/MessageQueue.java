package com.startai.queue;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

    private static LinkedBlockingQueue<Map<String, Object>> queue = new LinkedBlockingQueue<Map<String, Object>>();

    public static LinkedBlockingQueue<Map<String, Object>> getQueue() {
        return queue;
    }

    public static void setQueue(LinkedBlockingQueue<Map<String, Object>> queue) {
        MessageQueue.queue = queue;
    }

}
