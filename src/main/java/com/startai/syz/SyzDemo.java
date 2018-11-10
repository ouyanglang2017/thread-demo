package com.startai.syz;

public class SyzDemo {

    public  static  void getInfo(){
        System.out.println("获取信息");
    }
    public static void doit(){
        System.out.println("获取信息前");
        getInfo();
        System.out.println("获取信息后");
    }
    public static void main(String[]args){
        for (int i = 0;i<50;i++){
            doit();
        }

    }
}
