package binarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions
There can be duplicate elements in the array, and we can return any of the indices with same value.

Examples
A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
Corner Cases
What if A is null or A is of zero length? We should return -1 in this case.
 */
public class Closest {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,6,12,16};
        int target = 10;
        Closest obj = new Closest();
        System.out.println(obj.search(array, target));
    }

    private int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
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
        //post-processing
        if(Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        }
        return right;
    }

}
