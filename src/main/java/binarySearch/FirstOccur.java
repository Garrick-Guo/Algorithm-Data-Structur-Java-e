package binarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

Assumptions
There can be duplicate elements in the array.

Examples
A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 1

Corner Cases
What if A is null or A of zero length? We should return -1 in this case.
 */
public class FirstOccur {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,6,6,7,9,16};
        int target = 6;
        FirstOccur obj = new FirstOccur();
        System.out.println(obj.searchFirst(array, target));
        System.out.println(obj.searchLast(array, target));
    }
    private int searchFirst(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int middle = (right - left) / 2 + left;
            if (array[middle] >= target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    private int searchLast(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int middle = (right - left) / 2 + left;
            if (array[middle] <= target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
