package RecursionSorting;

import java.util.Arrays;

/*
Given an array of integers, move all the 0s to the right end of the array.
The relative order of the elements in the original array does not need to be maintained.
Assumptions:
The given array is not null.
Examples:
{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 */
public class MoveZero {
    public static void main(String[] args) {
        MoveZero obj = new MoveZero();
        int[] array = new int[]{1,0,3,0,1,2,1,3,0};
        System.out.println(Arrays.toString(obj.sort(array)));
    }
    private int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (array[j] == 0) {
                swap(array, i++, j);
            }
            j++;
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
