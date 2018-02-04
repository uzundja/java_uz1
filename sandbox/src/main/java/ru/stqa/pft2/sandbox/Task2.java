package ru.stqa.pft2.sandbox;

public class Task2 {

    public static void main(String[] args) {
        Point first = new Point(2, 4);
        Point second = new Point(2, 2);
        double d = distance(first, second);
        System.out.println("Расстояние между двумя точками а(x1,y1) и b(x2,y2) c координатами x1:" + first.x + " y1:" + first.y + " и x2:" + second.x + " y1:" + second.y + " = " + distance(first, second));
    }

    public static double distance(Point first, Point second) {
        return Math.sqrt(Math.pow((first.x - second.x), 2) + Math.pow((first.y - second.y), 2));
    }
}