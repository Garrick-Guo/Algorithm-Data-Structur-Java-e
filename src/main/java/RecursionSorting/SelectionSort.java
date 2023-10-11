package RecursionSorting;

import java.util.Arrays;

/*
Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int[] array = new int[]{4,2,-3,6,1};
        System.out.println(Arrays.toString(obj.sort(array)));
    }
    private int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int globalMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globalMin]) {
                    globalMin = j;
                }
            }
            swap(array, i, globalMin);
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
//Time Complexity: O(n^2)
//Spcae Complexiy: O(1)
