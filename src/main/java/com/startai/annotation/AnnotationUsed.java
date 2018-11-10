package com.startai.annotation;

import java.lang.reflect.Method;

public class AnnotationUsed {

    /**
     * 标注弃用或不推荐使用的方法
     */
    @Deprecated()
    public void unuseMethoud(){
        System.out.println("弃用");
    }

    /**
     * 关闭不当编译器警告信息。
     */
    @SuppressWarnings(value = "unused")
    public void warning(){
        int a = 1;
    }
    @AnnotationTest(id = "110",description = "Passwords must contain at least one numeric")
    public boolean  test(String password){
        System.out.println("使用注解！");
        return password.matches("\\w*\\d\\w*");
    }

    public static void main(String[]args) throws NoSuchMethodException {
        Class c = AnnotationUsed.class;
        Method method = c.getDeclaredMethod("test",String.class);

        AnnotationTest annotationTest = method.getAnnotation(AnnotationTest.class);
        String id = annotationTest.id();
        String des = annotationTest.description();
        System.out.println(id+","+des);
    }

}
