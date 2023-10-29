package JDK.Lectures.Lecture_04;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1,2,3,4,5,7);

        // iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // for each
        for (Integer i : collection) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Stream api
        collection.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
