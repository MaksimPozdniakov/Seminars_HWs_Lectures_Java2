package JavaJunior.HomeWorks.Hw_04;

/*
    Создайте базу данных (например, SchoolDB).
    В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
    Настройте Hibernate для работы с вашей базой данных.
    Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
    Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
    Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();
            // Начало транзакции
            session.beginTransaction();


            // пришлось написать SQL-скрипт для создания таблицы courses без него не работало создание таблицы!!!
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS courses (" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "duration INT NOT NULL, " +
                    "title VARCHAR(255), " +
                    "PRIMARY KEY (id)" +
                    ") ENGINE=InnoDB";

            // Выполнение SQL-скрипта
            session.createSQLQuery(sqlCreateTable).executeUpdate();

            // Создание объекта
            Course[] courses = new Course[10];
            for (int i = 0; i < courses.length; i++) {
                courses[i] = Course.create();
                session.save(courses[i]);
            }
            System.out.println("Objects course save successfully");


            // Получение всех Course из базы данных и их вывод (альтернатива верхней записи)
            List<Course> retrievedCourses = session.createQuery("FROM Course", Course.class).getResultList();
            for (Course course : retrievedCourses) {
                System.out.println("Retrieved course object: " + course);
            }
            System.out.println("Objects course retrieved successfully");


            // Обновление объекта
            for (Course course : retrievedCourses) {
                course.updateTitle();
                course.updateDuration();
            }
            System.out.println("Object course update successfully");


            // Удаление всех Course из базы данных
            for (Course course : retrievedCourses) {
                session.delete(course);
                System.out.println("Course object deleted: " + course);
            }


            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
