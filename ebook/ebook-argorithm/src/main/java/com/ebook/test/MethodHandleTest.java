package com.ebook.test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodHandleTest {

    public static final MethodType METHOD_TYPE = MethodType.methodType(String.class);

    static class ClassA {
        public void println(String s) {
            System.out.println("--A : " + s);

        }
    }

    static class ClassB {
        public void println(String s) {
            System.out.println("--B : " + s);

        }
    }

    public static void main(String[] args) throws Throwable {
//        Object obj = new Random().nextInt(2) == 0  ? new ClassA() : new ClassB();
        // 无论obj最终是哪个实现类，下面这句都能正确调用到println方法。
//        getPrintlnMethodHandle(obj).invokeExact("zhankers");

        testVirtualMethod();
        testConstructorMethod();
        testStaticMethod();
        testGetterField();
//        testPrivateMethod();
        testPrivateMethodUseReflect();
        test();
        test2();
    }

    private static MethodHandle getPrintlnMethodHandle(Object reveiver) throws Throwable {
        // MethodType：代表“方法类型”，
        MethodType mt = MethodType.methodType(void.class, String.class);
        /*
          lookup()方法来自于MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
          因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即this指向的对象，这个参数以前
          是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情。
         */

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodHandle asListMH = publicLookup.findStatic(Arrays.class, "asList", mt);

        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }

    private static Book book;

    static {
        book = new Book("Java从入门到放弃", 100.0, new String[]{"zhankers", "mifulz"});
    }

    /**
     * 测试方法句柄调用虚方法(普通实例方法)
     */
    public static void testVirtualMethod() throws Throwable {
        // 第一步，获取lookup实例
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // 第二步，获取方法类型（包含了方法的返回值（methodType()的第一个参数）和具体参数（methodType()第二个及以后的参数）。）
        MethodType mt = MethodType.methodType(String.class);
        // 第三步，获取方法句柄
        MethodHandle getBookInfoMH = lookup.findVirtual(Book.class, "getBookInfo", mt);
        // 第四步，调用方法
        String bookInfo = (String) getBookInfoMH.invoke(book);
        System.out.println(bookInfo);
    }

    /**
     * 方法句柄调用构造方法
     */
    public static void testConstructorMethod() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, String.class, Double.class, String[].class);
        MethodHandle newBookMH = lookup.findConstructor(Book.class, mt);
        Book newBook = (Book) newBookMH.invoke("深入理解JVM", 89.0, new String[]{"zxc"});
        System.out.println(newBook);
    }

    /**
     * 方法句柄调用静态方法
     */
    public static void testStaticMethod() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class, Object[].class);
        MethodHandle newBookMH = lookup.findStatic(Arrays.class, "toString", mt);
        String authors = (String) newBookMH.invoke(new String[]{"zhankers", "mifulz"});
        System.out.println(authors);
    }

    /**
     * 使用方法句柄方法字段(不能方位私有属性)
     */
    public static void testGetterField() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle nameMH = lookup.findGetter(Book.class, "name", String.class);
        String name = (String) nameMH.invoke(book);

//        MethodHandle priceMH = lookup.findGetter(Book.class, "price", Double.class);
//        Double price = (Double)priceMH.invoke(book);

        System.out.println(name);
    }

    public static void testPrivateMethod() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class);
        MethodHandle mh = lookup.findSpecial(Book.class, "formatBook", mt, Book.class);
        System.out.println(mh.invoke(book));
    }

    public static void testPrivateMethodUseReflect() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Method formatBook = Book.class.getDeclaredMethod("formatBook");
        formatBook.setAccessible(true);
        MethodHandle formatBookMH = lookup.unreflect(formatBook);
        String formatStr = (String)formatBookMH.invoke(book);
        System.out.println(formatStr);

    }


    public static void test() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodType mt = MethodType.methodType(String.class, String.class);
        MethodHandle concatMH = lookup.findVirtual(String.class, "concat", mt);
        String concatStr = (String)concatMH.invoke("yaunde", "zhankers");
        System.out.println(concatStr);

    }

    public static void test2() throws Exception {

        // 使用反射获取构造方法创建Book对象
        Constructor<Book> bookConstructor = Book.class.getConstructor(String.class, Double.class, String[].class);
        Book books = bookConstructor.newInstance("Java从入门到放弃", 100.0, new String[]{"zhankers", "mifulz"});

        // 反射读取私有属性
        Field priceField = Book.class.getDeclaredField("price");
        priceField.setAccessible(true);
        Double price = (Double)priceField.get(books);

        // 反射读取私有方法
        Method formatBook = Book.class.getDeclaredMethod("formatBook");
        formatBook.setAccessible(true);
        String formatStr = (String)formatBook.invoke(books);



    }
}