package binarySearch;

import java.util.Arrays;

/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order,
find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

Assumptions
A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length

Return
A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
public class KClosest {
    public static void main(String[] args) {
        KClosest obj = new KClosest();
        int[] array = new int[]{0,0,1,2,3,3,4,7,7,8};
        int target = 3;
        int k = 3;
        System.out.println(Arrays.toString(obj.search(array, target, k)));
    }
    private int[] search(int[] array, int target, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[]{};
        }
        int index = findClosest(array, target);
        int[] result = new int[k];
        result[0] = array[index];
        int left = index - 1;
        int right = index + 1;
        for (int i = 1; i < k; i++) {
            if (left < 0 && right > array.length - 1) {
                return result;
            } else if (left < 0) {
                result[i] = array[right];
                right++;
            } else if (right > array.length - 1) {
                result[i] = array[left];
                left--;
            } else if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) { //the smaller elements are always preferred.
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }
    private int findClosest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int middle = (right - left) / 2 + left;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {//the smaller elements are always preferred.
            return left;
        } else {
            return right;
        }
    }

}
