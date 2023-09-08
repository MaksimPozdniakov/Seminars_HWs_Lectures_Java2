package HomeWork.HW_03.model;

import HomeWork.HW_03.categories.Employee;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllEmployee implements Iterable<Employee>{

    ArrayList<Employee> allEmployees = new ArrayList<>();

    @Override
    public Iterator<Employee> iterator() {
        return allEmployees.iterator();
    }

    public void addE(Employee employee) {
        allEmployees.add(employee);
    }




    // возвращаем список сотрудников из AllEmployee, для сортировки
    public List<Employee> getAllEmoloyees() {
        return allEmployees;
    }





}
