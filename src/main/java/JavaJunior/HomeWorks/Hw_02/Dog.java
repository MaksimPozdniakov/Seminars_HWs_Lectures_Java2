package JavaJunior.HomeWorks.Hw_02;

public class Dog extends Animal {

    private final String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void dogGuards() {
        System.out.println("Собака охраняет.....");
    }

    public void makeSound() {
        System.out.println("Собака лает.....");
    }

    @Override
    public String toString() {
        return name + ", " + name + ", " + breed;
    }
}
