package JavaCore.HomeWork.HW_03.categories;

import java.util.Random;

public abstract class Employee implements Comparable<Employee>{
    protected String name;
    protected String surName;
    protected double salary;
    protected int id;



    protected static Random random = new Random();
    protected static int counter = 0;
    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

    @Override
    public int compareTo(Employee object) {
        return Double.compare(salaryCalculation(), object.salaryCalculation());
    }



    {
        id = ++counter;
    }

    public Employee(String surName, String name, double salary) {
        this.surName = surName;
        this.name = name;
        this.salary = salary;
    }

    //region Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //endregion

    protected abstract double salaryCalculation();

    @Override
    public String toString() {
        return "Employee{" +
                ", id=" + id +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
