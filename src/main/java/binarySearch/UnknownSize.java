package binarySearch;
/*
Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions
dictionary A is not null
dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds

Examples
A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 */
public class UnknownSize {
    public static int[] LargetArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    public static void main(String[] args) {
        UnknownSize obj = new UnknownSize();
        //test cases
        Dictionary dict = new DictImpl(new int[]{1, 3, 4, 4, 6, 10, 11, 12, 15, 15});
        int target = 0;
        System.out.println(dict.toString() + " target: " + target);
        System.out.println("Expect: -1, Actual: " + obj.search(dict, target));
        target = 6;
        System.out.println(dict.toString() + " target: " + target);
        System.out.println("Expect: 4, Actual: " + obj.search(dict, target));
        dict = new DictImpl(LargetArray(100000));
        target = 99999;
        System.out.println(dict.toString() + " target: " + target);
        System.out.println("Expect: 99999, Actual: " + obj.search(dict, target));
    }
    private int search(Dictionary dict, int target) {
        if (dict == null || dict.get(0) == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            left = right;
            right *= 2;
        }
        int result = binarySearch(dict, target, left, right);
        return result;
    }
    private int binarySearch(Dictionary dict, int target, int left, int right) {
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (dict.get(middle) == null || dict.get(middle) > target) {
                right = middle - 1;
            } else if (dict.get(middle) == target) {
                return middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
//Time Complexity: O(logT), T is the index of target value;
//Spcae Complexity: O(1)
