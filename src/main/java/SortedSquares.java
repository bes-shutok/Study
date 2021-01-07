/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.*/

public class SortedSquares {

    static class Test {
        
        void duplicateZeros1(int[] arr) {
            int capacity = arr.length;
            for (int i = 0; i < capacity; i++){
                if (arr[i]==0) {
                    shiftRight(arr, i);
                    i++;
                }
            }
        }
        void shiftRight(int[] arr, int j) {
            for (int i=arr.length-1; i > j; i--) {
                arr[i]=arr[i-1];
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        t.duplicateZeros1(arr);
        System.out.println(arr.toString());
        arr = new int[]{1,0,2,3,0,4,5,0};
        //t.duplicateZeros2(arr);
        System.out.println(arr.toString());

    }
}
