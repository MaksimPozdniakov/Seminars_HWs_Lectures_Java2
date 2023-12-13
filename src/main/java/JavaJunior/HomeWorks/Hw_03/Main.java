package JavaJunior.HomeWorks.Hw_03;

/*
    Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
    Обеспечьте поддержку сериализации для этого класса.
    Создайте объект класса Student и инициализируйте его данными.
    Сериализуйте этот объект в файл.
    Десериализуйте объект обратно в программу из файла.
    Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = Stream.of(
                new Student("Maksim", 18, 5.0),
                new Student("Yana", 18, 5.0),
                new Student("German", 20, 5.0)
        ).toList();

        try(FileOutputStream fileOutputStream = new FileOutputStream("listStudents.txt", false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            // Сериализация списка студентов
            objectOutputStream.writeObject(students);
            System.out.println("Список студентов сериализован!");
        }

        // Десериализация и вывод данных для каждого студента
        List<Student> deserializedStudents = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream("listStudents.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Заполняем ArrayList десериализованными объектами
            deserializedStudents = (List<Student>) objectInputStream.readObject();
        }

        System.out.println("Список студентов десериализован!");
        for (Student deserializedStudent : deserializedStudents) {
            System.out.println();
            System.out.println("\tИмя: " + deserializedStudent.getName());
            System.out.println("\tВозраст: " + deserializedStudent.getAge());
            System.out.println("\tGPA: " + deserializedStudent.getGPA());
        }
    }
}
