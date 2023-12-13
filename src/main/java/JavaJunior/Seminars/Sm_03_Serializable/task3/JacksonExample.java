package JavaJunior.Seminars.Sm_03_Serializable.task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class JacksonExample {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        // Создание объекта Person
        Person person = new Person();
        person.setName("Alice");
        person.setAge(30);

        // Имя файла для записи и чтения
        String filename = "person.json";

        // Настройка форматирования для записи в JSON файл
        ObjectWriter writer = objectMapper.writer().with(SerializationFeature.INDENT_OUTPUT);

        try {
            // Сериализация объекта в JSON и запись в файл с отступами
            writer.writeValue(new File(filename), person);
            System.out.println("Object serialized and saved to " + filename);

            // Десериализация объекта из файла
            Person deserializedPerson = objectMapper.readValue(new File(filename), Person.class);
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
