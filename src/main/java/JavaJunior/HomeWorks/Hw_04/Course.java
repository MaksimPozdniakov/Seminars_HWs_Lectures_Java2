package JavaJunior.HomeWorks.Hw_04;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    private static final String[] titles = new String[] {
            "Основы программирования на Java",
            "Веб-разработка с использованием HTML, CSS и JavaScript",
            "Python для начинающих",
            "Разработка мобильных приложений на Android",
            "Алгоритмы и структуры данных",
            "Frontend-разработка: основы и практика",
            "Базы данных и SQL для программистов",
            "Тестирование программного обеспечения",
            "Разработка игр на Unity",
            "DevOps"};

    private static final Random random = new Random();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course(){}

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create() {
        return new Course(
                titles[random.nextInt(titles.length)],
                random.nextInt(10, 20));
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration() {
        duration = random.nextInt(10, 20);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id =" + id +
                ", название курса ='" + title + '\'' +
                ", количество уроков =" + duration +
                '}';
    }
}
