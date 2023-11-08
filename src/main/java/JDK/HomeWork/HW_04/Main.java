package JDK.HomeWork.HW_04;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        // region random data
        String[] phoneNumbers = {
                "89267157342", "89258945287", "89257778899","89261234589","89267895623","89254562893",
                "89257896321", "89263257896", "89257865423", "89251478963"};
        String[] names = {"Maksim","Yana","Inna","Ted","Bred","Sam","Kal","Peter","Tom","Bob"};
        int[] serviceNumbers = new int[10];
        for (int i = 0; i < serviceNumbers.length; i++) {
            serviceNumbers[i] = rnd.nextInt(999999) + 100000;
        }
        String[] workExperience = new String[10];
        for (int i = 0; i < workExperience.length; i++) {
            workExperience[i] = rnd.nextInt(25) + " years";
        }
        // endregion

        addMethod(employeeDirectory,rnd,phoneNumbers,names,serviceNumbers,workExperience);
        addMethod(employeeDirectory,rnd,phoneNumbers,names,serviceNumbers,workExperience);
        addMethod(employeeDirectory,rnd,phoneNumbers,names,serviceNumbers,workExperience);
        addMethod(employeeDirectory,rnd,phoneNumbers,names,serviceNumbers,workExperience);
        addMethod(employeeDirectory,rnd,phoneNumbers,names,serviceNumbers,workExperience);

        // for test searchServiceNumber
        employeeDirectory.addNewEmployee(545422,
                phoneNumbers[rnd.nextInt(phoneNumbers.length)],
                names[rnd.nextInt(names.length)],
                workExperience[rnd.nextInt(workExperience.length)]);


        // resultMethods
        System.out.println("Весь справочник");
        employeeDirectory.printBase();

        System.out.println();
        System.out.println("Поиск сотрудника по табельному номеру");
        employeeDirectory.searchServiceNumber("545422");

        System.out.println();
        System.out.println("Поиск сотрудника по стажу");
        employeeDirectory.searchWorkExperience(16);

        System.out.println();
        System.out.println("Поиск номер телефона сотрудника по имени");
        employeeDirectory.searchPhone("Maksim");
    }

    private static void addMethod(
            EmployeeDirectory employeeDirectory, Random rnd, String[] phoneNumbers, String[] names,
            int[] serviceNumbers, String[] workExperience) {

        employeeDirectory.addNewEmployee(
                serviceNumbers[rnd.nextInt(serviceNumbers.length)],
                phoneNumbers[rnd.nextInt(phoneNumbers.length)],
                names[rnd.nextInt(names.length)],
                workExperience[rnd.nextInt(workExperience.length)]);
    }
}
