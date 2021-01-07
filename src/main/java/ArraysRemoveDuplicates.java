import java.util.Arrays;

// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class ArraysRemoveDuplicates {

    public static void main(String[] args) {
        ArraysRemoveDuplicates t = new ArraysRemoveDuplicates();
        int[] arr = {1,1,2};
        System.out.println("The remaining length =" + t.removeDuplicates1(arr));
        System.out.println(Arrays.toString(arr));
    }

    int removeDuplicates1(int[] nums) {
        int length = nums.length, removed = 0;
        if (length == 0) return 0;
        int val = nums[0];
        for (int i=1; i < length; i++) {
            if (nums[i] == val) {
                removed++;
            } else {
                val = nums[i];
                nums[i-removed] =nums[i];
            }
        }
        return length - removed;
    }
}
