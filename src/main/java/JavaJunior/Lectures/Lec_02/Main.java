package JavaJunior.Lectures.Lec_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<?> car = Class.forName("JavaJunior.Lectures.Lec_02.Car");
        Constructor<?>[] constructors = car.getConstructors();

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int tmp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, tmp * 2);
        System.out.println(gaz);

        Method[] methods = gaz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
