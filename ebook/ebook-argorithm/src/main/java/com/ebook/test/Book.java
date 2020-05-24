package com.ebook.test;

import java.util.Arrays;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-12-27 23:56
 */
public class Book {
    String name;
    private Double price;
    private String[] authors;

    public Book() {}

    public Book(String name, Double price, String[] authors) {
        this.name = name;
        this.price = price;
        this.authors = authors;
    }

    public String getBookInfo() {
       return "Book:" + name + " Price:" + price + " Authors" + Arrays.toString(authors);
    }

    private String formatBook() {
        return name + " > " + price;
    }

    @Override
    public String toString() {
        return String.format("Book{name='%s', price=%s, authors=%s}", name, price, Arrays.toString(authors));
    }
}
