package com.ebook.test;

public class Parent {
	
	public static int a = 0;
	public static int b = 1;
	public static void printA() {
		System.out.println("In Parent, a = " + a);
	}

	public void printB() {
		System.out.println("In Parent, b = " + b);
	}
}