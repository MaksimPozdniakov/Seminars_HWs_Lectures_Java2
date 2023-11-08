package Seminars.Seminar_03;

import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = Worker.getEmployees(15);

//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }

        System.out.println();
        System.out.print("Отсортированный список по зарплате");
//        Collections.sort(employees, new EmployeeNameComparator());
        Collections.sort(employees);
        System.out.println();

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.print("Отсортированный список по Фамилии");
        Collections.sort(employees, new EmployeeNameComparator());
        for (Employee it: employees) {
            System.out.println(it);
        }
    }
}
