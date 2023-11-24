package JavaJunior.Seminars.Sm_01_Lambda_StreamAPI.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax_StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int min = numbers.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);
        System.out.println(min);

        int max = numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
        System.out.println(max);
    }
}
