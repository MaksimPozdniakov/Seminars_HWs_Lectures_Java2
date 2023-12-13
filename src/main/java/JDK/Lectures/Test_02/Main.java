package JDK.Lectures.Test_02;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Создание объекта
        Person person = new Person("Alice", 30);

        // Сериализация объекта
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            outputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) inputStream.readObject();
            System.out.println(
                    "Deserialized Person: " + deserializedPerson.getName() + ", Age: " +
                            deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
