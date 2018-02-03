package ru.stqa.uz1.sandbox;

public class MyFirstProgramm {

    public static void main(String[] args) {
       hello("world");
       hello("user");
       hello("Anton");

       Square s = new Square(5);
       System.out.println( "Площадь квадрата со стороной " + s.l + " = " + area(s) );

       Rectangle r = new Rectangle(4,6);
       System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));

       SegmentX x = new SegmentX(2,4);
       System.out.println( "Длина отрезка по X c координатами X1:" + x.x1 + " и X2:" + x.x2 + " = " +area(x));
    }

    public static void hello(String somebody) {
        System.out.println ("Hello, " + somebody + "!");
    }

    public static double area (Square s) {
        return s.l * s.l;
    }

    public static double area (Rectangle r){
        return r.a * r.b;
    }

    public static double area (SegmentX x){ return x.x2 - x.x1; }
}