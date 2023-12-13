package JDK.Lectures.Test_02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Класс, который будет сериализоваться через Externalizable
class Person implements Externalizable {
    private String name;
    private int age;

    // Пустой конструктор (обязателен для Externalizable)
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Ручная сериализация объекта
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Ручная десериализация объекта
        name = (String) in.readObject();
        age = in.readInt();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

