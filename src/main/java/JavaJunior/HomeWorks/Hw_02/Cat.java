package JavaJunior.HomeWorks.Hw_02;

public class Cat extends Animal {

    private String color;

    public Cat(){}

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void catIsSleeping() {
        System.out.println("Кот спит.....");
    }

    public void makeSound() {
        System.out.println("Кот мяукает.....");
    }

    @Override
    public String toString() {
        return name + ", " + name + ", " + color;
    }
}
