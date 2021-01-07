import java.util.Arrays;

/*
*
* Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
* You may return any answer array that satisfies this condition.
* 
* */

public class ArraysSortByParity {

    public static void main(String[] args) {
        ArraysSortByParity t = new ArraysSortByParity();
        int[] arr = {0,1,0,3,12};
        t.sortArrayByParity1(arr);
        System.out.println("Updated array: " + Arrays.toString(arr));
        t.sortArrayByParity2(arr);
        System.out.println("Updated array: " + Arrays.toString(arr));
        t.sortArrayByParity3(arr);
        System.out.println("Updated array: " + Arrays.toString(arr));
    }

    public int[] sortArrayByParity1(int[] A) {
        if (A == null || A.length < 2) return A;
        int l = A.length -1, swap;
        for (int i=0; i < l; i++) {
            if (A[i] % 2 !=0) {
                while (A[l] % 2 != 0 && l > i) l--;
                swap = A[l];
                A[l] = A[i];
                A[i] = swap;
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        if (A.length < 2) return A;
        int l = A.length - 1, i = 0, swap;
        while (i < l) {
            if ((A[i] & 1) == 1) {
                while ((A[l] & 1) == 1 && l > i) l--;
                swap = A[l];
                A[l] = A[i];
                A[i++] = swap;
            } else i++;
        }
        return A;
    }

    /*
    * Runtime: 0 ms
    * Memory Usage: 40.7 MB
    * */
    public int[] sortArrayByParity3(int[] A) {
        if (A.length < 2) return A;
        int l = A.length - 1, i = 0, swap;
        while (i < l) {
            if ((A[i] & 1) == 1) {
                while ((A[l] & 1) == 1 && l > i) l--;
                swap = A[l];
                A[l--] = A[i];
                A[i++] = swap;
            } else i++;
        }
        return A;
    }

}
