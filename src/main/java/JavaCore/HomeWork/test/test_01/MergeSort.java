package JavaCore.HomeWork.test.test_01;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3,5,6,7,1,90,55,567,6767,8};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }
    public static void merge(int[] arr, int left, int middle, int right) {
        int leftLength = (middle - left) + 1;
        int rightLength = right - middle;
        int[] arrLeft = new int[leftLength];
        int[] arrRight = new int[rightLength];
        System.arraycopy(arr, left, arrLeft, 0, leftLength);
        System.arraycopy(arr, middle + 1, arrRight, 0, rightLength);

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = left;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (arrLeft[leftIndex] <= arrRight[rightIndex]) {
                arr[resultIndex] = arrLeft[leftIndex];
                leftIndex++;
            } else {
                arr[resultIndex] = arrRight[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < leftLength) {
            arr[resultIndex] = arrLeft[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < rightLength) {
            arr[resultIndex] = arrRight[rightIndex];
            rightIndex++;
            resultIndex++;
        }

    }
}
