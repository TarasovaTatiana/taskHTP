package example.task2;

import java.io.FileNotFoundException;

public class Main {
    private final static String PATH_CIRCLE = "src/main/resources/files/task2/input.txt";
    private final static String PATH_POINTS = "src/main/resources/files/task2/points.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Circle myCircle = new Circle();
        myCircle.getPointPosition(PATH_CIRCLE, PATH_POINTS);

    }

}



