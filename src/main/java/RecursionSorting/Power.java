package RecursionSorting;
/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

Examples
power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32

Corner Cases
In this question, we assume 0^0 = 1.
 */
public class Power {
    public static void main(String[] args) {

    }
    private long power(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return a * half * half;
        }
    }
}
//Time Complexity: O(logb)
//Space complexity: O(logb)
