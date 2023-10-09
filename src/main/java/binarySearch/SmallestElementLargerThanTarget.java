package binarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the smallest element in A that is larger than T or
return -1 if there is no such index.

Assumptions
There can be duplicate elements in the array.

Examples
A = {1, 2, 3}, T = 1, return 1
A = {1, 2, 3}, T = 3, return -1
A = {1, 2, 2, 2, 3}, T = 1, return 1

Corner Cases
What if A is null or A of zero length? We should return -1 in this case.
 */
public class SmallestElementLargerThanTarget {
    public static void main(String[] args) {
        SmallestElementLargerThanTarget obj = new SmallestElementLargerThanTarget();
        int[] array = new int[]{4,9,12,13,15,20,21,23,25,28,31,33,34,38,40,42,45,46,48,53,54,56,57,58};
        int target = 6;
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
            if (array[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (array[left] > target) {
            return left;
        }
        if (array[right] > target) {
            return right;
        }
        return -1;
    }

}
