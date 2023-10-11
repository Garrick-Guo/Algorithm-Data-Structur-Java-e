package RecursionSorting;

import java.util.Arrays;

/*
Given an array of integers, sort the elements in the array in ascending order.
The merge sort algorithm should be used to solve this problem.

Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, -2, -3, 1, 6, 0, -4};
        MergeSort obj = new MergeSort();
        System.out.println(Arrays.toString(obj.sort(array)));
    }
    private int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        int[] result = megerSort(array, left, right);
        return result;
    }
    private int[] megerSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int middle = (right + left) / 2;
        int[] leftResult = megerSort(array, left, middle);
        int[] rightResult = megerSort(array, middle + 1, right);
        return meger(leftResult, rightResult);
    }
    private int[] meger(int[] leftR, int[]rightR) {
        int[] result = new int[leftR.length + rightR.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (leftIndex >= leftR.length) {
                result[i] = rightR[rightIndex++];
            } else if (rightIndex >= rightR.length) {
                result[i] = leftR[leftIndex++];
            } else if (leftR[leftIndex] < rightR[rightIndex]) {
                result[i] = leftR[leftIndex++];
            } else {
                result[i] = rightR[rightIndex++];
            }
        }
        return result;
    }
    // Time Complexity : O((n + nlogn) = O(logn)
    //Space Complexity : O(call stack + heap) =  O(logn + n) = n
}
