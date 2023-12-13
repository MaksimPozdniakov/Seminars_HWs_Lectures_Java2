package JavaJunior.HomeWorks.Hw_02;

public abstract class Animal {

    protected String name;
    protected int age;

    public Animal(){}

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

   public abstract String toString();
}
