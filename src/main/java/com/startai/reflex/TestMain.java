package com.startai.reflex;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //获取class三种方式
        //第一种
        Person person = new Person();
        Class pc = person.getClass();
        System.out.println(pc.getName());
        //第二种
        Class pc2 = Person.class;
        System.out.println(pc2.getName());
        //第三种
        Class pc3 = Class.forName("com.startai.reflex.Person");
        System.out.println(pc3.getName());
        //获取public的属性
        Field[] fields = pc.getFields();
        for (Field f : fields) {
            System.out.println("获取public的属性：" + f.getName());
        }
        //获取所以属性包括private的
        Field[] fields2 = pc.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println("获取所以属性包括private的：" + f.getName());
        }
        //获取public的方法
        Method[] methods = pc.getMethods();
        for (Method m : methods) {
            System.out.println("获取public的方法并且包括超类的：" + m.getName());
        }
        //获取所有方法
        Method[] methods2 = pc.getDeclaredMethods();
        Object om = pc.newInstance();

//        for (Method m : methods2) {
//            System.out.println("获取所有方法但不包括超类的：" + m.getName());
//            //设置accessible保证可以拿到私有方法
//            m.setAccessible(true);
//            m.invoke(om);
//        }

        //获取指定属性,不包括private私有的
        Field fs = pc.getField("age");
        Object o = pc.newInstance();
        Object age = fs.get(o);
        System.out.println("获取指定属性的值：" + age);
        Class type = fs.getType();
        System.out.println("获取指定属性的类型：" + type);

        //获取所有属性中指定属性,包括private私有的
        Field fs2 = pc.getDeclaredField("name");
        fs2.setAccessible(true);
        Object o2 = pc.newInstance();
        Object name = fs2.get(o2);
        System.out.println("获取指定属性的值：" + name);
        Class type2 = fs2.getType();
        System.out.println("获取指定属性的类型：" + type2);

        //获取方法的参数，返回值等等
        Method saym = pc.getDeclaredMethod("say", String.class, int.class);
        saym.setAccessible(true);
        Object sayObj  = pc.newInstance();
        String typename = saym.getGenericReturnType().getTypeName();
        Class[] classes = saym.getParameterTypes();
        for (Class c : classes) {
            System.out.println("获取参数类型："+c.getName());
        }
        System.out.println("获取方法返回值类型：" + typename);
        //调用带参数的私有方法
        Object returnSay = saym.invoke(sayObj,"aaaa",1);
        System.out.println(returnSay);



        //利用反射获取配置文件
        Properties properties = new Properties();
        try {
            properties.load(TestMain.class.getClassLoader().getResourceAsStream("app.properties"));
            System.out.println(properties.getProperty("admin"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
