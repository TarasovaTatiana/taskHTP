package example.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Circle {

    private final static String ERROR_COOR_CENTER_CIRCLE = "Некорректные координаты для центра окружности";
    private final static String ERROR_COOR_RADIUS = "Некорректные координаты для радиуса";
    private final static String ERROR_COOR_POINT = "Некорректные координаты для точки";

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle() {
    }

    public void getPointPosition(String argsCurcle, String argsPoint) throws FileNotFoundException {
        File fileManager = new File(argsCurcle);

        Scanner scanner1 = new Scanner(fileManager);
        String[] coordinatsCurcle = null;
        double xCurcle = 0;
        double yCurcle = 0;
        try {
            coordinatsCurcle = scanner1.nextLine().split(" ");
            if (coordinatsCurcle.length != 2) {
                System.out.println(ERROR_COOR_CENTER_CIRCLE);
                System.exit(0);
            }
            xCurcle = Double.parseDouble(coordinatsCurcle[0]);
            yCurcle = Double.parseDouble(coordinatsCurcle[1]);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_COOR_CENTER_CIRCLE);
            System.exit(0);
        }


        Point center1 = new Point(xCurcle, yCurcle);

        double radius = 0;
        try {
            radius = scanner1.nextDouble();
        } catch (NumberFormatException e) {
            System.out.println(ERROR_COOR_RADIUS);
            System.exit(0);
        }

        fileManager = new File(argsPoint);
        scanner1 = new Scanner(fileManager);

        while (scanner1.hasNext()) {
            String[] coordinatsPoint;
            double xPoint = 0;
            double yPoint = 0;
            try {
            coordinatsPoint = scanner1.nextLine().split(" ");
                if (coordinatsPoint.length != 2) {
                    System.out.println(ERROR_COOR_POINT);
                    continue;
                }
                xPoint = Double.parseDouble(coordinatsPoint[0]);
                yPoint = Double.parseDouble(coordinatsPoint[1]);
            } catch (NumberFormatException e) {
                System.out.println(ERROR_COOR_POINT);
                continue;
            }
            Point point = new Point(xPoint, yPoint);

            double distance = Math.sqrt(Math.pow(point.getX() - center1.getX(), 2) + Math.pow(point.getY() + center1.getY(), 2));
            if (distance == radius) {
                System.out.println(0);
            } else if (distance < radius) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
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
