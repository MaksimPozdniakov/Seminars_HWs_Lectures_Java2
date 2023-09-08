package HomeWork.HW_03.categories;

import java.util.ArrayList;

public class Worker extends Employee {

    public Worker(String surName, String name, double salary) {
        super(surName, name, salary);
    }

    public static Employee addWorker() {
        return new Worker(surNames[random.nextInt(surNames.length)],
                names[random.nextInt(names.length)],
                random.nextInt(200000) + 30000);
    }

//    public static ArrayList<Employee> fillArray(int count) {
//        ArrayList<Employee> workers = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            workers.add(addWorker());
//        }
//        return workers;
//    }

    @Override
    protected double salaryCalculation() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%d) %s %s, Среднемесячная зарплата: %.2f", id,name,surName,salary);
    }
}




