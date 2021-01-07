/*Given an array A of integers, return true if and only if it is a valid mountain array.

        Recall that A is a mountain array if and only if:

        A.length >= 3
        There exists some i with 0 < i < A.length - 1 such that:
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]
        */

public class ArraysValidMountain {

    public static void main(String[] args) {
        ArraysValidMountain t = new ArraysValidMountain();
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Is this a valid mountain? " + t.validMountainArray1(arr));
        arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Is this a valid mountain? " + t.validMountainArray2(arr));
    }

    /*
    * 51 / 51 test cases passed.
    * Status: Accepted
    * Runtime: 3 ms
    * Memory Usage: 40.2 MB
    * * */
    boolean validMountainArray1(int[] A) {
        if (A == null || A.length <3) return false;
        Boolean climb = true;
        if (A[0] >= A[1]) return false;
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                return false;
            } else if (climb && A[i] < A[i-1]) {
                climb = false;
            } else if (!climb && A[i] >= A[i-1]) {
                return false;
            }
        }
        return !climb;
    }

    boolean validMountainArray2(int[] A) {
        int i=1 ,cap = A.length;
        if (A == null || cap <3) return false;
        while (i < cap -1 && A[i] > A[i-1]) i++;
        while (i > 1 && i < cap && A[i] < A[i-1]) i++;
        if (i == cap) {
            return true;
        }
        return false;
    }

}
