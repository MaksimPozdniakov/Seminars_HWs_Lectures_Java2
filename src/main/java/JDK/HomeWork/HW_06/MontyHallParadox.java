package JDK.HomeWork.HW_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int totalSteps = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        Random random = new Random();

        for (int i = 1; i <= totalSteps; i++) {
            int carPosition = random.nextInt(3); // Автомобиль находится за одной из трех дверей
            int playerChoice = random.nextInt(3); // Игрок делает выбор

            // Ведущий открывает одну из не выбранных дверей с козой
            int doorWithGoat;
            do {
                doorWithGoat = random.nextInt(3);
            } while (doorWithGoat == carPosition || doorWithGoat == playerChoice);

            // Игрок принимает решение о смене выбора
            int newChoice;
            do {
                newChoice = random.nextInt(3);
            } while (newChoice == playerChoice || newChoice == doorWithGoat);

            // Проверка победы или поражения при смене выбора
            boolean win = newChoice == carPosition;
            results.put(i, win);
        }

        // Вывод статистики по победам и поражениям
        int wins = 0;
        int losses = 0;
        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);
    }
}

