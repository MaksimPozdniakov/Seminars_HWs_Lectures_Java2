package HomeWork.HW_03.categories;

import java.util.ArrayList;

public class Freelancer extends Employee {

    protected static int[] hourRate = new int[] {265, 350, 300, 301, 275, 159, 315, 209};

    public Freelancer(String surName, String name, double salary) {
        super(surName, name, salary);
    }

    public static Employee addFreelancer() {
        return new Freelancer(surNames[random.nextInt(surNames.length)],
                names[random.nextInt(names.length)],
                20.8 * 8 * hourRate[random.nextInt(hourRate.length)]);
    }

    @Override
    protected double salaryCalculation() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%d) %s %s, Среднемесячная зарплата: %.2f", id,name,surName,salary);
    }

}
