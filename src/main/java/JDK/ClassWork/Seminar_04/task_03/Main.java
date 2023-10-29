package JDK.ClassWork.Seminar_04.task_03;

/*
    В рамках выполнения задачи необходимо:
        ● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
        значение
        ● Найдите человека с самым маленьким номером телефона
        ● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("123", "Константин");
        phoneBook.put("123123", "Мария");
        phoneBook.put("12311", "Вячеслав");
        phoneBook.put("12", "Анна");
        phoneBook.put("911", "Евгений");

        for (Map.Entry<String, String> entry: phoneBook.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
        }
        // длинная запись
//        System.out.println(phoneBook.entrySet()
//                .stream().min((e1, e2) -> e1.getKey().compareTo(e2.getKey())).get().getValue());
        // запись короче
//        System.out.println(phoneBook.entrySet()
//                .stream().min(Comparator.comparing(Map.Entry::getKey)).get().getValue());
        // короткая запись
        System.out.println(phoneBook.entrySet()
                .stream().min(Map.Entry.comparingByKey()).get().getValue());

        System.out.println(phoneBook.entrySet()
                .stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey());
    }
}
