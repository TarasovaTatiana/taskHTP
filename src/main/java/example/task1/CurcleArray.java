package example.task1;

import java.util.ArrayList;
import java.util.List;

public class CurcleArray {
    public static void main(String[] args) {
        List<Integer> answer = getIntegerList(5,4);
        printAnswer(answer);
    }

    private static void printAnswer(List<Integer> answer) {
        answer.forEach(System.out::print);
    }

    private static List<Integer> getIntegerList(int n, int m) {
        int range = n;
        int [] arr = createCurcleArray(range);
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        int step = m;
        int start = 0;
        int position = 0;

        while (true){
            position = position + step - 1;
            if (position >= range){
                while (position >= range){
                    position = position - range;
                }
            }
            if (position != start){
                answer.add(arr[position]);
            } else {
                break;
            }
        }
        return answer;
    }

    public static int[] createCurcleArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;

    }
}
