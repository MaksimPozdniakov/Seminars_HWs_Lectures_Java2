package JDK.ClassWork.Seminar_04.task_01;

import java.util.Arrays;

public class Main {

    private static void swap(Object[] arr, int from, int to) {
        Object temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        Object[] arr = {1, 2.0f, "heloo"};
        System.out.println(Arrays.toString(arr));

        swap(arr, 0, 2);
        System.out.println(Arrays.toString(arr));
    }
}
