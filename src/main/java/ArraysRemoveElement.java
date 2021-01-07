import java.util.Arrays;

// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class ArraysRemoveElement {

    public static void main(String[] args) {
        ArraysRemoveElement t = new ArraysRemoveElement();
        int[] arr = {3,2,2,3};
        System.out.println("The remaining length =" + t.removeElement1(arr,3));
        System.out.println(Arrays.toString(arr));
        arr = new int[] {3,2,2,3};
        System.out.println("The remaining length =" + t.removeElement2(arr,3));
        System.out.println(Arrays.toString(arr));
    }

    int removeElement1(int[] nums, int val) {
        int length = nums.length, removed = 0;
        for (int i=0; i < length; i++) {
            if (nums[i] == val) {
                removed++;
            } else {
                nums[i-removed] =nums[i];
            }
        }
        return length - removed;
    }

    int removeElement2(int[] nums, int val) {
        int length = nums.length;
        for (int i=0; i < length; i++) {
            if (nums[i] == val) nums[i--] = nums[length-- - 1];
        }
        return length;
    }
}
