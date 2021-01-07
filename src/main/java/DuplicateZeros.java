import java.util.Arrays;

// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros t = new DuplicateZeros();
        int[] arr = {-4, -1, 0, 3, 10};
        t.duplicateZeros1(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[] {-4, -1, 0, 3, 10};
        t.duplicateZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }

    void duplicateZeros1(int[] arr) {
        int capacity = arr.length;
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == 0) {
                shiftRight(arr, i++);
            }
        }
    }

    void shiftRight(int[] arr, int j) {
        int i = arr.length - 1;
        while (i > j) {
            arr[i] = arr[i - 1];
            i--;
        }
    }

    void duplicateZeros2(int[] arr) {
        int last = arr.length - 1;
        int possibleDubs = 0;
        for (int i = 0; i <= (last - possibleDubs); i++) {
            if (arr[i] == 0) {
                if (i == last - possibleDubs) {
                    arr[last] = 0;
                    last--;
                } else possibleDubs++;
            }
        }
        for (int i = last - possibleDubs; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[last] = 0;
                last--;
            }
            arr[last] = arr[i];
            last--;
        }
    }
}
