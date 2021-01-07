import java.util.Arrays;

// Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
public class ArraysFindDouble {

    public static void main(String[] args) {
        ArraysFindDouble t = new ArraysFindDouble();
        int[] arr = {10,2,5,3};
        System.out.println("Is there a double for any element? " + t.checkIfExist1(arr));
        //System.out.println(Arrays.toString(arr));
    }

    /*
    104 / 104 test cases passed.
	Status: Accepted
Runtime: 1 ms
Memory Usage: 39 MB
    */
    boolean checkIfExist1(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (Arrays.binarySearch(arr, i+1, arr.length, arr[i]/2) >= 0) return true;
            }
            if (Arrays.binarySearch(arr, i+1, arr.length, arr[i]*2) >= 0) return true;
        }
        return false;
    }

}
