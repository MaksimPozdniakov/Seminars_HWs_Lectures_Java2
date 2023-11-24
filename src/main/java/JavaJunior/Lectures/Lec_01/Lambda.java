package JavaJunior.Lectures.Lec_01;
/*
Рассматриваем подход, который работает только с функциональным интерфейсом
В качестве блокиратора, чтобы никто не мог добавить еще метод в функциональный интерфейс существует
специальная аннотация @FunctionalInterface
 */

public class Lambda {
    public static void main(String[] args) {
        // Запись без лямбды:
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x+y);
//            }
//        };

        // Запись через лямбду (одно действие):
        PlainInterface plainInterface = (x,y) -> x+y;
        PlainInterface plainInterface2 = (x,y) -> Integer.compare(x,y);

        // Перепишем plainInterface и plainInterface2 еще короче:
        PlainInterface plainInterface3 = Integer::sum;
        PlainInterface plainInterface4 = Integer::compare;

        // Запись через лямбду (несколько действий):
//        PlainInterface plainInterface = (x,y) -> {
//            // какие-то действия
//            // какие-то действия
//            // какие-то действия
//            return String.valueOf(x+y);
//        };

        System.out.println(plainInterface.action(5,3));
        System.out.println(plainInterface2.action(5,3));
        System.out.println(plainInterface3.action(5,3));
        System.out.println(plainInterface4.action(5,3));

    }
}
