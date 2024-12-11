package example.task1;

import example.task1.exception.BelowZeroException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CurcleArray {
    private static final String ASK_NUMBER = "Напишите натуральное положительное число, которое задаст массив";
    private static final String ASK_STEP = "Напишите натуральное положительное число, которое задаст шаг";
    private static final String ERROR_MISMATCH = "Вы написали не натуральное число";
    private static final String ERROR_BELOW_ZERO = "Вы написали неположительное натуральное число";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = 0;
        int step = 0;
        try {
            System.out.println(ASK_NUMBER);
            length = scanner.nextInt();
            if (length < 0){
                throw new BelowZeroException();
            }
            System.out.println(ASK_STEP);
            step = scanner.nextInt();
            if (step < 0){
                throw new BelowZeroException();
            }
            List<Integer> answer = getIntegerList(length,step);
            printAnswer(answer);
        } catch (InputMismatchException e){
            System.out.println(ERROR_MISMATCH);
        } catch (BelowZeroException e) {
            System.out.println(ERROR_BELOW_ZERO);
        }

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
