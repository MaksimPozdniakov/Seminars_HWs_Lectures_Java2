package JavaJunior.HomeWorks.Hw_01;

/*
    Напишите программу, которая использует Stream API для обработки списка чисел.
    Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,4,5,6);
        double averageNumber = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
        System.out.println("Среднее значение всех четных чисел в списке: " + averageNumber);
    }
}
