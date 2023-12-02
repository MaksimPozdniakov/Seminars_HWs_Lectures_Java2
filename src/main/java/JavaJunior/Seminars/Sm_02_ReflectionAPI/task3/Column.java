package JavaJunior.Seminars.Sm_02_ReflectionAPI.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Это означает, что аннотация будет доступна через отражение (reflection)
                                    // во время работы программы.
@Target(ElementType.FIELD) // означает, что данная аннотация может использоваться только для описания свойств или
                           // переменных внутри класса.
public @interface Column {
    String name();
    boolean primaryKey() default false;
}
