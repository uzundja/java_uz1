package ru.stqa.uz2.sandbox;

public class Task2 {

    public static void main(String[] args) {
        Point p = new Point (2,4,2,2);
        System.out.println("Расстояние между двумя точками а(x1,y1) и b(x2,y2) c координатами x1:" + p.x1 + " y1:" + p.y1 + " и x2:" + p.x2 + " y1:"+ p.y2 + " = "  + distance(p));

    }

    public static double  distance (Point p) {
        return Math.sqrt(Math.pow((p.x2 - p.x1), 2) + Math.pow((p.y2 - p.y1), 2));
    }
}