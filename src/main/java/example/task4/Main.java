package example.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String pathToNumbers = "src/main/resources/files/task4/numbers.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(pathToNumbers);
        Scanner scanner = new Scanner(file);
        List<Integer> integerList = new ArrayList<>();
        while (scanner.hasNext()){
            integerList.add(Integer.valueOf(scanner.next()));
        }

        int [] array = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            array[i] = integerList.get(i);

        }


        int minMoves = minMovesToOneNumber(array);
        System.out.println(minMoves);
    }

    private static int minMovesToOneNumber(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }

        int minMoves = Integer.MAX_VALUE;
        for(int target = min; target <= max; target++){
            int moves = 0;
            for (int num : nums){
                moves += Math.abs(num - target);
            }
            minMoves = Math.min(minMoves, moves);
        }
        return minMoves;

    }
}
