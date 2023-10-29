package JDK.HomeWork.HW_04;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int serviceNumber;
    private String phoneNumber;
    private String name;
    private String workExperience;

    public Employee(int serviceNumber, String phoneNumber, String name, String workExperience) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return serviceNumber + "," +
                phoneNumber + "," +
                name + "," +
                workExperience;
    }

}
