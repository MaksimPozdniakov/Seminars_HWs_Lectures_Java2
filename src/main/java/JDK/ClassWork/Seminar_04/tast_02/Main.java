package JDK.ClassWork.Seminar_04.tast_02;

public class Main {
    public static void main(String[] args) {
//        MyArray<String> array = new MyArray<>();
//        array.add("1");
//        array.add("2");
//        array.add("3");
//        array.add("4");
//        array.add("5");
//        System.out.println(array);
//
//        array.remove(1);
//        System.out.println(array);

//        MyArray<Integer> myArray = new MyArray<>();
//        myArray.add(1);
//        myArray.add(2);
//        myArray.add(3);
//        myArray.add(4);
//        myArray.add(5);
//        System.out.println(myArray);
//
//        myArray.remove(1);
//        System.out.println(myArray);
        MyArray<Person> myArray = new MyArray<>();
        Person person = new Person("Максим");
        Person person2 = new Person("Максим");
        Person person3 = new Person("Максим");
        Person person4 = new Person("Максим");
        Person person5 = new Person("Максим");
        myArray.add(person);
        myArray.add(person2);
        myArray.add(person3);
        myArray.add(person4);
        myArray.add(person5);
        System.out.println(myArray);

        myArray.remove(1);
        System.out.println(myArray);
    }
}
