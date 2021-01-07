import java.util.Arrays;

/*
*
* Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
* 
* */

public class ArraysSortedSquares {

    public static void main(String[] args) {
        ArraysSortedSquares t = new ArraysSortedSquares();
        int[] arr = {-3,-3,-2,1};
        System.out.println("Updated array: " + Arrays.toString(t.sortedSquares1(arr)));
        arr = new int[] {-3,-3,-2,1};
        System.out.println("Updated array: " + Arrays.toString(t.sortedSquares2(arr)));

        }

    /*
    * Runtime: 1 ms
    * Memory Usage: 41.4 MB
    *  */
    public int[] sortedSquares1(int[] A) {
        int start = 0, size = A.length, end = size -1;
        int[] resp = new int[size];
        while(start <= end) {
            int SquareStart = A[start]*A[start];
            int SquareEnd = A[end]*A[end];
            if (SquareStart >  SquareEnd ) {
                resp[--size] = SquareStart;
                start++;
            } else {
                resp[--size] = SquareEnd;
                end--;
            }
        }
        return resp;
    }

    /*
    * Runtime: 2 ms
    * Memory Usage: 41.2 MB
    * */
    public int[] sortedSquares2(int[] A) {
        if (A == null || A.length <1) return A;
        int l = A.length;
        for (int i=0; i < l; i++) {
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }

/*    public int[] sortedSquares2(int[] A) {
        if (A == null || A.length <1) return A;
        int end = A.length -1, start = 0;
        int startSquare = A[start]*A[start];
        int endSquare = A[end]*A[end];

        while (start <= end) {
            if (startSquare > endSquare) {
                A[start]=A[end];
                A[end--] = startSquare;
                startSquare = endSquare;
                endSquare = A[end]*A[end];
            } else {
                A[end--] = endSquare;
                if (end >= 0) endSquare = A[end]*A[end];
            }
        }
        return A;
    }*/


}
