package com.startai.sys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Demo {
    public void   getStr() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\a.txt")));
        for (int i = 90;i>64;i--){
            for (int j =97;j<123;j++){
                for (int k = 1;k<1000001;k++){
                    System.out.println((char)i+""+(char)j+""+getOO(k));
                    pw.println((char)i+""+(char)j+""+getOO(k));
                    pw.flush();
                }
            }

        }
        pw.close();
    }
    public String getOO(int num){
        DecimalFormat df=new DecimalFormat("000000");
        String str2=df.format(num);
        return str2;
    }
    public static void main(String[]args) throws FileNotFoundException {
      //  new Demo().getStr();
        System.out.println(26*26*1000000);
       // new Demo().getOO(100);
    }
}
