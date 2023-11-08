package JDK.HomeWork.HW_04v2;

import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class EmployeeDirectory {
    private Employee employee;
    private List<Employee> listEmployee = new ArrayList<>();

    // метод добавление нового сотрудника в справочник
    public void addNewEmployee(String serviceNumber, String phoneNumber, String name, String workExperience) {
        employee = new Employee(serviceNumber, phoneNumber, name, workExperience);
        listEmployee.add(employee);
    }

    // метод, который ищет сотрудника по табельному номеру
    public void search1(String serviceNumber) {
        for (Employee el: listEmployee) {
            if (serviceNumber.equals(el.getServiceNumber())) {
                System.out.printf("Табельный номер: %s, Номер телефона: %s, Имя: %s, Стаж: %s years\n",
                        el.getServiceNumber(), el.getPhoneNumber(), el.getName(), el.getWorkExperience());
            }
        }
    }

    // метод, который выводит номер телефона сотрудника по имени (может быть список)
    public void search2(String name) {
        for (Employee el: listEmployee) {
            if (name.equals(el.getName())) {
                System.out.printf("Номер телефона: %s, Имя: %s\n", el.getPhoneNumber(), el.getName());
            }
        }
    }

    // метод, который ищет сотрудника по стажу (может быть список)
    public void search3(String workExperience) {
        for (Employee el: listEmployee) {
            if (workExperience.equals(el.getWorkExperience())) {
                System.out.printf("Табельный номер: %s, Номер телефона: %s, Имя: %s, Стаж: %s years\n",
                        el.getServiceNumber(), el.getPhoneNumber(), el.getName(), el.getWorkExperience());
            }
        }
    }



    public void printListEmployee() {
        for (Employee el: listEmployee) {
            System.out.printf("Табельный номер: %s, Номер телефона: %s, Имя: %s, Стаж: %s years\n",
                    el.getServiceNumber(), el.getPhoneNumber(), el.getName(), el.getWorkExperience());
        }
    }
}
