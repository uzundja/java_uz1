package ru.stqa.pft2.sandbox;

public class Task2 {

    public static void main(String[] args) {
        Point p1 = new Point(2, 2);
        Point p2 = new Point (4,2);

        System.out.println("Расстояние между двумя точками а(x1,y1) и b(x2,y2) c координатами x1:" + p1.x + " y1:" + p2.y + " и x2:" + p2.x + " y1:" + p2.y + " = " + p1.distance(p2));
    }

}