package binarySearch;

import java.util.Arrays;

/*
implementation for Dictionary to create the test case for unknownSize
 */
class DictImpl implements Dictionary {
    private int[] array;
    public DictImpl(int[] array) {
        this.array = array;
    }
    //if index out of bound, null will be returned.
    @Override
    public Integer get(int index) {
        if (array == null || array.length <= index) {
            return null;
        }
        return array[index];
    }
    //For pretty printout
    @Override
    public String toString(){
        if (array == null) {
            return String.valueOf(null);
        }
        if (array.length <= 10) {
            return Arrays.toString(array);
        }
        //Truncate output if the array is too large
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= 5; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append("...");
        for (int i = array.length - 4; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
