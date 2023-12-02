package JavaJunior.Seminars.Sm_02_ReflectionAPI.task3.models;

import JavaJunior.Seminars.Sm_02_ReflectionAPI.task3.Column;
import java.util.UUID;

@JavaJunior.Seminars.Sm_02_ReflectionAPI.task3.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
