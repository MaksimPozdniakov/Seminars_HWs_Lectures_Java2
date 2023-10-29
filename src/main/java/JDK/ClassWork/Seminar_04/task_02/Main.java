package JDK.ClassWork.Seminar_04.task_02;

/*
    В рамках выполнения задачи необходимо:
        ● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
        добавьте повторяющиеся значения
        ● Получите уникальный список Set на основании List
        ● Определите наименьший элемент (алфавитный порядок)
        ● Определите наибольший элемент (по количеству букв в слове но в обратном
        порядке)
        ● Удалите все элементы содержащие букву ‘A’
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = generateList();
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
//        System.out.println(getMaxByLength(set));
        removeByChar(set);
        System.out.println(set);
    }

    static void removeByChar(Set<String> set){
        // через лямбду
        set.removeIf(s -> s.contains("A"));
    }

    static String getMaxByLength(Set<String> set){
        // через stream()
        return set.stream().max(Comparator.comparingInt(String::length)).get();
    }

    static String getMinByAlphabet(Set<String> set){
        Set<String> set1 = new TreeSet<>(set);
        Iterator<String> iterator = set1.iterator();
        if (iterator.hasNext()){
            return iterator.next();
        }
        return null;

        /*
        вариант через stream()
        return set.stream().min(String::compareTo);
         */

        /*
        более короткий вариант в одну строку:
        return new TreeSet<>(set).first();
         */
    }

    static List<String> generateList(){
        List<String> list = new ArrayList<>();
        list.add("Maks");
        list.add("Maks");
        list.add("Klaks");
        list.add("Baksa");
        list.add("Baksa");
        list.add("Baks");
        list.add("Shmaks");
        list.add("Shmaks");
        return list;
    }
}
