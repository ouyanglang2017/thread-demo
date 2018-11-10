package com.startai.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class SysInThread extends Thread{
    private LinkedBlockingQueue<Map<String,Object>> queue = MessageQueue.getQueue();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Map<String,Object> map = new HashMap<String, Object>();
            map.put(line,line);
            try {
                queue.put(map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
