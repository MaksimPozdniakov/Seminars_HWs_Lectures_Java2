package JavaCore.HomeWork.test.test_01;

import java.util.ArrayList;
import java.util.List;

public class BumbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>
                (List.of(1, 2, 5, 7, 8, 4, 2, 4, 6, 8, 0, 22, 44, 6, 3445, 1, 8));
        System.out.println(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size() - 1; j++) {
                if (arrayList.get(j) < arrayList.get(i)) {
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(i));
                    arrayList.set(i, temp);
                }
            }
        }

        System.out.println(arrayList);
    }
}
