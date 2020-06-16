package com.ebook.test;

public class DemoJavaTest {

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test2());
        System.out.println(test3());
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = (j++);
        }

        System.out.println(j);
    }

    public static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }

    public static int test2() {
        int temp = 1;
        try {
            System.out.println(temp);
            return temp++;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }

    public static int test3() {
        int temp = 1;
        try {
            System.out.println(temp);
            return (++temp);
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}