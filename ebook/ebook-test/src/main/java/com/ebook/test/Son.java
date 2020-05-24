package com.ebook.test;

public class Son extends Parent {
    private static int a = 3;

	@Override
    public void printB() {
        System.out.println("IOn Son, a =" + a);
    }

	public void test() {
		System.out.println(Son.super.getClass().getName()); // com.ebook.test.Son
		Son.super.printB();
	}

	class Inner1{
        private int c = 5;

        public void printC() {
            System.out.println("In Inner c = " + c);
            Son.this.printB();
        }

        class Inner2{
            private int d = 5;

            public void print() {
                System.out.println("In Inner d = " + d);
                Son.this.printB();
                Inner1.this.printC();
            }
        }
    }


    public static void main(String[] args) {

        new Son().test();
        printA();
    }
}