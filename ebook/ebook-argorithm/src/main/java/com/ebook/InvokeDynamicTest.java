package com.ebook;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-12-22 00:58
 */
public class InvokeDynamicTest {
    /*public static void main(String[] args) {
        Consumer<String> comsumer = s -> System.out.println(s);
        comsumer.accept("Hello Lambda!");
    }*/





    private static MethodType MT_BootstrapMethod() {
        return MethodType
                .fromMethodDescriptorString(
                        "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String; Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable {
        return MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }


    public static void main(String[] args) throws Throwable {
        // methodHandleTest().invokeExact("icyfenix");
        INDY_BootstrapMethod().invokeExact("icyfenix");

    }

    public static MethodHandle methodHandleTest() throws Throwable {
        MethodType methodType = MethodType.fromMethodDescriptorString(
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String; Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);

        MethodHandle bootstrapMethod = MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", methodType);

        Object testMethod = bootstrapMethod.invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));

        CallSite callSite = (CallSite) testMethod;

        return callSite.dynamicInvoker();

    }

    public static void testMethod(String s) {
        System.out.println("hello String:" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }
}
