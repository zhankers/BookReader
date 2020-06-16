package com.ebook.scala.demo.casepak;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2020-05-25 01:15
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account("z1");
        System.out.println(account.name());

        Account apply = Account.apply("zh");
    }
}
