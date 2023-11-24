package JavaJunior.Lectures.Lec_01;

import java.util.Arrays;
import java.util.List;

public class Stream_API {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "eeeeeeeeee", "dd", "Привет", "sss");

        // с перезаписью
//        list = list.stream()
//                .filter(str -> str.length() > 4)
//                .toList();
//
//        System.out.println(list);

        // без перезаписи
//        list.stream()
//                .filter(str -> str.length() > 4)
//                .forEach(System.out::println);

//        Arrays.asList(1,2,3,4,5).stream()
//                .map(item -> item * item)
//                .forEach(System.out::println);

//        Arrays.asList(1,10,4,222,13,1).stream()
//                .sorted()
//                .distinct() // избавляемся от дубликатов
//                .forEach(System.out::println);

        // кастомные классы
        List<User> users = Arrays.asList(new User("Pavel", 45), new User("Pavel", 25), new User("Pavel", 25));
        users.stream()
                .map(user -> new User(user.name, user.age - 5))
                .filter(user -> user.age <= 25)
                .forEach(System.out::println);
    }
}
