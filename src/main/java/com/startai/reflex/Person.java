package com.startai.reflex;

import java.util.HashMap;
import java.util.Map;

public class Person {
    //私有属性
    private String name = "Tom";
    //公有属性
    public int age = 18;

    //构造方法
    public Person() {
    }

    //私有方法
    private Map say(String content, int num) {
        System.out.println("private say()..."+ content+ num);
        Map<String,Integer> map = new HashMap<>();
        map.put(content,num);
        return map;
    }

    //公有方法
    public void work() {
        System.out.println("public work()...");
    }
}
