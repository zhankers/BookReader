package com.ebook.interview;

class Car extends Vehicle
{
    public static void main (String[] args)
    {
        new  Car(). run();

        new  Car().run();
    }
    private final void run()
    {
        System. out. println ("Car");
    }

    public final void run2()
    {
        System. out. println ("Car2");
    }
}
class Vehicle
{
    private final void run()
    {
        System. out. println("Vehicle");
    }
}