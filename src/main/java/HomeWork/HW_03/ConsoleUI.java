package HomeWork.HW_03;

import HomeWork.HW_03.categories.Employee;
import HomeWork.HW_03.categories.Freelancer;
import HomeWork.HW_03.categories.Worker;
import HomeWork.HW_03.model.AllEmployee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner sc = new Scanner(System.in);
    private final AllEmployee allEmployee = new AllEmployee();
    private final ArrayList<Employee> workers = new ArrayList<>();
    private final ArrayList<Employee> freelancer = new ArrayList<>();
    public void printFullBase() {

        for (int i = 0; i < 5; i++) {
            Employee employee1 = Worker.addWorker();
            allEmployee.addE(employee1);
            workers.add(employee1);

            Employee employee2 = Freelancer.addFreelancer();
            allEmployee.addE(employee2);
            freelancer.add(employee2);
        }

        // Итерация по сотрудникам с использованием итератора, вроде как)
        for (Employee employee : allEmployee) {
            System.out.println("\t" + employee);
        }
    }

    // получаем список сотрудников из AllEmployee и сортируем его
    public void sortBase() {
        List<Employee> employees = allEmployee.getAllEmoloyees();
        Collections.sort(employees);

        int num = 1;
        for (Employee employee: employees) {
            System.out.printf("\t%d) %s %s, Среднемесячная зарплата: %.2f\n",
                    num, employee.getName(), employee.getSurName(), employee.getSalary());
            num++;
        }
    }

    public void printWorkers() {
        int num = 1;
        for (Employee employee: workers) {
            System.out.printf("\t%d) %s %s, Среднемесячная зарплата: %.2f\n",
                    num, employee.getName(), employee.getSurName(), employee.getSalary());
            num++;
        }
    }

    public void printfreelancer() {
        int num = 1;
        for (Employee employee: freelancer) {
            System.out.printf("\t%d) %s %s, Среднемесячная зарплата: %.2f\n",
                    num, employee.getName(), employee.getSurName(), employee.getSalary());
            num++;
        }
    }

    public void sortWorkers() {
        Collections.sort(workers);
        int num = 1;
        for (Employee employee: workers) {
            System.out.printf("\t%d) %s %s, Среднемесячная зарплата: %.2f\n",
                    num, employee.getName(), employee.getSurName(), employee.getSalary());
            num++;
        }
    }

    public void sortfreelancer() {
        Collections.sort(freelancer);
        int num = 1;
        for (Employee employee: freelancer) {
            System.out.printf("\t%d) %s %s, Среднемесячная зарплата: %.2f\n",
                    num, employee.getName(), employee.getSurName(), employee.getSalary());
            num++;
        }
    }

    public void print() {
        while (true) {
            String menu = """
                    1. Открыть базу.
                    2. Закрыть базу.
                    """;
            System.out.print(menu);

            System.out.print("\tВыберите пункт меню: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    printFullBase();
                    System.out.println();
                    System.out.print("\tОтсортировать по зарплате (Y - да/ N - нет) ");
                    String answer1 = sc.next();
                    if (answer1.equalsIgnoreCase("y") ||
                            answer1.equalsIgnoreCase("у")) {
                        sortBase();
                    }

                    boolean flag = true;
                    while (flag) {
                        String submenu = """
                                1. Показать только штатных сотрудников.
                                2. Показать только фрилансеров.
                                3. Выйти.
                                """;

                        System.out.println();
                        System.out.print(submenu);
                        System.out.print("\tВыберите пункт меню: ");
                        int choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1 -> {
                                printWorkers();
                                System.out.println();
                                System.out.print("\tОтсортировать по зарплате (Y - да/ N - нет) ");
                                String answer = sc.next();
                                if (answer.equalsIgnoreCase("y") ||
                                        answer.equalsIgnoreCase("у")) {
                                    sortWorkers();
                                }
                            }
                            case 2 -> {
                                printfreelancer();
                                System.out.println();
                                System.out.print("\tОтсортировать по зарплате (Y - да/ N - нет) ");
                                String answer = sc.next();
                                if (answer.equalsIgnoreCase("y") ||
                                        answer.equalsIgnoreCase("у")) {
                                    sortfreelancer();
                                }
                            }
                            case 3 -> flag = false;
                        }
                    }
                }
                case 2 -> System.exit(0);
            }
        }
    }
}
