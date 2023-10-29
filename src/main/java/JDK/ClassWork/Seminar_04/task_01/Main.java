package JDK.ClassWork.Seminar_04.task_01;

/*
В рамках выполнения задачи необходимо:
    * Создайте коллекцию мужских и женских имен с помощью интерфейса List
    * Отсортируйте коллекцию в обратном порядке
    * Отсортируйте коллекцию по количеству букв в слове
    * Разверните коллекцию
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = generateList();
        System.out.println(list);
        sortByAlphafet(list);
        System.out.println(list);

        sortByLength(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

    }

    // Отсортируйте коллекцию по алфавиту в обратном порядке
    private static void sortByAlphafet(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    // сортировка по длине
    private static void sortByLength(List<String> list) {
        list.sort(new Comparator<String>() {   // <- так выглядит реализация через анонимный класс
            @Override
            public int compare(String o1, String o2) {
                /* первый вариант*/ // return Integer.compare(o1.length(), o2.length());
                /* второй вариант*/ return o1.length() - o2.length();
            }
        });
    }

    static List<String> generateList(){
        List<String> list = new ArrayList<>();
        list.add("Maks");
        list.add("Klaks");
        list.add("Baksa");
        list.add("Baks");
        list.add("Shmaks");
        return list;
    }
}
