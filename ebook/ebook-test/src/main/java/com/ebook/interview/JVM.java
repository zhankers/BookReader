package com.ebook.interview;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-07-09 15:39
 */
public class JVM {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(()->test("abc",false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }
    static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static void test(String s,boolean isGC)  {
        try {

            threadLocal.set(s);
            //失去对threadLocal的强引用 ,help gc
            //threadLocal = null;

            if (isGC) {
                System.out.println("===zhjiinggc===");
                System.gc();
            }

            System.out.println("----------------threadLocal.get:: " + threadLocal.get());
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
