package binarySearch;

import java.util.Arrays;

/*
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.

Examples:

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

Corner Cases:
What if A is null or A is of zero length? We should return -1 in this case.
 */
public class ClassicBinary {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 2, 2, 2, 3, 4};
        int target1 = 3;
        int target2 = 6;
        int target3 = 2;
        ClassicBinary obj = new ClassicBinary();
        System.out.println(Arrays.toString(array1) + " T = " + target1 + "return " + obj.search(array1, target1));
        System.out.println(Arrays.toString(array1) + " T = " + target2 + "return " + obj.search(array1, target2));
        System.out.println(Arrays.toString(array2) + " T = " + target3 + "return " + obj.search(array2, target3));
    }

    private int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
//TC: logn
//SC: 1
