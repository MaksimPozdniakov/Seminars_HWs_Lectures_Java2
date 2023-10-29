package JDK.HomeWork.HW_04;

import lombok.NoArgsConstructor;
import java.util.*;

@NoArgsConstructor
public class EmployeeDirectory {
    private HashMap<String, ArrayList<String>> listEmployees = new HashMap<>();
    private Employee employee;

    // метод добавление нового сотрудника в справочник
    public void addNewEmployee(int serviceNumber, String phoneNumber, String name, String workExperience) {
        employee = new Employee(serviceNumber, phoneNumber, name, workExperience);

        String[] convertArray = employee.toString().split(",");
        ArrayList<String> convertArrayList = new ArrayList<>();
        convertArrayList.addAll(Arrays.asList(convertArray));

        addSaveEmployee(convertArrayList);
    }

    // метод сохранения нового сотрудника в справочник
    public void addSaveEmployee(ArrayList<String> convertArrayList) {
        ArrayList<String> resultConvert = new ArrayList<>();
        resultConvert.add(convertArrayList.get(1));
        resultConvert.add(convertArrayList.get(2));
        resultConvert.add(convertArrayList.get(3));
        listEmployees.put(convertArrayList.get(0), resultConvert);
    }

    // метод форматирующий вывод
    private void formatMethod(Map.Entry entry) {
        String stringReplaceBrackets = entry.getValue().toString().replace("[", "").replace("]","");
        String[] employeeData = stringReplaceBrackets.split(",");

        String employeeNumber = entry.getKey().toString();

        String formattedString = String.format("Табельный номер: %s, Номер телефона: %s, Имя: %s, Стаж: %s", employeeNumber, employeeData[0], employeeData[1], employeeData[2]);
        System.out.println(formattedString);
    }

    // метод печати справочника в консоль
    public void printBase() {
        for (Map.Entry entry: listEmployees.entrySet()) {
            formatMethod(entry);
        }
    }

    // метод, который ищет сотрудника по табельному номеру
    public void searchServiceNumber(String userChoice) {
        boolean flag = false;
        for (Map.Entry <String, ArrayList<String>> entry: listEmployees.entrySet()) {
            String key = entry.getKey();
            if (userChoice.equals(key)) {
                formatMethod(entry);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Такого сотрудника в справочнике нет");
        }
    }

    // метод, который ищет сотрудника по стажу (может быть список)
    public void searchWorkExperience(int workExperience) {
        boolean flag = false;
        for (Map.Entry entry: listEmployees.entrySet()) {

            String stringReplaceBrackets = entry.getValue().toString()
                    .replace("[", "").replace("]","")
                    .replace(" years", "").replace(" ", "");

            String[] employeeData = stringReplaceBrackets.split(",");

            if (workExperience == Integer.parseInt(employeeData[2])) {
                formatMethod(entry);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Такого сотрудника в справочнике нет");
        }
    }

    // метод, который выводит номер телефона сотрудника по имени (может быть список)
    public void searchPhone(String name) {
        boolean flag = false;
        for (Map.Entry entry: listEmployees.entrySet()) {
            String stringReplaceBrackets = entry.getValue().toString()
                    .replace("[", "").replace("]","")
                    .replace(" years", "").replace(" ", "");

            String[] employeeData = stringReplaceBrackets.split(",");

            if (employeeData[1].equals(name)) {
                System.out.printf("Номер телефона: %s сотрудника: %s", employeeData[0], employeeData[1]);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Такого сотрудника в справочнике нет");
        }
    }
}