package RecursionSorting;

import java.util.Arrays;

/*
Given an array of integers, sort the elements in the array in ascending order.
The quick sort algorithm should be used to solve this problem.

Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] array = new int[]{4, 2, -3, 6, 1};
        System.out.println(Arrays.toString(obj.sort(array)));
    }
    private int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        return array;
    }
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partiction(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }
    private int partiction(int[] array, int left, int right) {
        int range = right - left + 1;
        int pivotIndex = (int)(Math.random() * range) + left;
        int pivot = array[pivotIndex];
        int leftIndex = left;
        int rightIndex = right - 1;
        swap(array, pivotIndex, right);
        /*
        [left, leftIndex): less than pivot
        [leftIndex, rigthIndex]: searching area
        (rightIndex, right - 1]: equal or larger than pivot
         */
        while(leftIndex <= rightIndex) {
            if (array[leftIndex] < pivot) {
                leftIndex++;
            } else if (rightIndex >= pivot) {
                rightIndex--;
            } else {
                swap(array, leftIndex++, rightIndex--);
            }
        }
        swap(array, leftIndex, right);
        return leftIndex;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
