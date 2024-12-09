package example.task2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Circle myCircle = new Circle();
        System.out.println(myCircle.getPointPosition("files/task2/input.txt", "files/task2/points.txt"));

    }

}



