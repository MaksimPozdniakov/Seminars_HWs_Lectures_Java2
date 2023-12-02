package JavaJunior.HomeWorks.Hw_02;

/*
    Создайте абстрактный класс "Animal" с полями "name" и "age".
    Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
    Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    Выведите на экран информацию о каждом объекте.
    Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        // Создайте массив объектов типа "Animal"
        Animal[] animals = new Animal[6];
        animals[0] = new Dog("Ник",5,"Акита-ину");
        animals[1] = new Dog("Тайсон",5,"Алабай");
        animals[2] = new Dog("Никсон",5,"Английский сеттер");
        animals[3] = new Cat("Том", 5, "Серый");
        animals[4] = new Cat("Боб", 5, "Коричневый");
        animals[5] = new Cat("Тед", 5, "Белый");

        // Используем Reflection API
        task1(animals);

    }

    public static void task1(Animal[] animals)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        Set<String> setNamesClass = new HashSet<>();
        for (Animal animal : animals) {
            setNamesClass.add(animal.getClass().getName());
        }

        for (String s: setNamesClass) {
            Class<?> animalClass = Class.forName(s);
            String nameClass = animalClass.getSimpleName();
            StringBuilder result = getStringBuilder(animalClass, nameClass);
            System.out.println(result);
        }

        System.out.println();
        Set<Animal> setObjectsClass = new HashSet<>(Arrays.asList(animals));
        for (Animal animal: setObjectsClass) {
            Method makeSoundMethod = animal.getClass().getMethod("makeSound");
            makeSoundMethod.invoke(animal);
        }
    }

    private static StringBuilder getStringBuilder(Class<?> animalClass, String nameClass) {
        StringBuilder result = new StringBuilder("Все экземпляры класса (" + nameClass + ") содержат: ");

        Constructor[] constructors = animalClass.getConstructors();
        if (constructors.length > 0) {
            int count = 0;
            for (Constructor constructor: constructors) {
                count++;
            }

            if (count == 1) {
                result.append(count).append(" конструктор");
            } else {
                result.append(count).append(" конструктора");
            }
        }
        result.append("; ");

        Field[] fields = animalClass.getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            if (j != 0) {
                result.append(", ");
            } else {
                result.append("Поля: ");
            }
            result.append(fields[j].getName());
        }
        result.append("; ");

        Method[] methods = animalClass.getDeclaredMethods();
        for (int j = 0; j < methods.length; j++) {
            if (j != 0) {
                result.append(", ");
            } else {
                result.append("Методы: ");
            }
            result.append(methods[j].getName());
        }
        result.append("; ");
        return result;
    }

}
