package example.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle() {
    }

    public int getPointPosition(String argsCurcle, String argsPoint) throws FileNotFoundException {
        File fileManager = new File(argsCurcle);

        Scanner scanner1 = new Scanner(fileManager);

        String [] coordinatsCurcle = scanner1.nextLine().split(" ");
        double xCurcle = Double.parseDouble(coordinatsCurcle[0]);
        double yCurcle = Double.parseDouble(coordinatsCurcle[1]);
        Point center1 = new Point(xCurcle, yCurcle);

        double radius = scanner1.nextDouble();

        fileManager = new File(argsPoint);
        scanner1 = new Scanner(fileManager);
        String [] coordinatsPoint = scanner1.nextLine().split(" ");
        double xPoint = Double.parseDouble(coordinatsPoint[0]);
        double yPoint = Double.parseDouble(coordinatsPoint[1]);
        Point point = new Point(xPoint, yPoint);

        double distance = Math.sqrt(Math.pow(point.getX() - center1.getX(), 2) + Math.pow(point.getY() + center1.getY(), 2));
        if (distance == radius) {
            return 0;
        } else if (distance < radius){
            return 1;
        } else {
            return 2;
        }
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
