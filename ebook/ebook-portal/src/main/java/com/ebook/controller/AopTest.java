package com.ebook.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {



    @Before("execution(* cn.mm.contacts.controller.ContactController.contactHome(..))")
    public void testBefore() {
        System.out.println("testBefore");

    }

    @After("execution(* cn.mm.contacts.controller.ContactController.contactHome(..))")
    public void testAfter() {
        System.out.println("testAfter");
    }

    @AfterReturning("execution(* cn.mm.contacts.controller.ContactController.contactHome(..))")
    public void testAfterReturning() {
        System.out.println("testAfterReturning");
    }

    @AfterThrowing("execution(* cn.mm.contacts.controller.ContactController.contactHome(..))")
    public void testAfterThrowing() {
        System.out.println("testAfterThrowing");
    }

}