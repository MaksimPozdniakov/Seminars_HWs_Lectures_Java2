package JavaJunior.Seminars.Sm_03_Serializable.task1;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class UserData implements Serializable {

    private String name;
    private int age;
    private transient String password;

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
