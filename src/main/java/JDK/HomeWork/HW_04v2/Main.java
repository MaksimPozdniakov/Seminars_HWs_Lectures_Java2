package JDK.HomeWork.HW_04v2;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory listEmployee = new EmployeeDirectory();
        listEmployee.addNewEmployee("159789", "89267157342", "Maksim", "15");
        listEmployee.addNewEmployee("956321", "89258945287", "Yana", "10");

        listEmployee.printListEmployee();

        System.out.println();
        listEmployee.search1("159789");

        System.out.println();
        listEmployee.search2("Yana");

        System.out.println();
        listEmployee.search3("15");
    }
}
