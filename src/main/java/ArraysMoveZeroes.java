import java.util.Arrays;

/*
*
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* 
* */

public class ArraysMoveZeroes {

    public static void main(String[] args) {
        ArraysMoveZeroes t = new ArraysMoveZeroes();
        int[] arr = {0,1,0,3,12};
        t.moveZeroes1(arr);
        System.out.println("Updated array: " + Arrays.toString(arr));
        t.moveZeroes2(arr);
        System.out.println("Updated array: " + Arrays.toString(arr));
    }

    // This one could be inefficient for [1,3,4,5,6,0] with re-writing every array value by its own value
    void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = nums.length -1, j = 0;
        for (int i = 0; i <= l; i++) {
            if (nums[i] != 0) {
                nums[j++]=nums[i];
            }
        }
        // and this second loop
        for (int i = j; i <= l; i++) {
            nums[i] = 0;
        }
    }

    // This one could be inefficient for [0,1,2,3,4,...] with moving starting 0
    void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = nums.length -1, slowPointer = 0;
        for (int i = 0; i <= l; i++) {
            if (nums[i] != 0) {
                // Should avoid rewriting the same index
                if (i!=slowPointer) {
                    nums[slowPointer++]=nums[i];
                    nums[i] = 0;
                } else {
                    slowPointer++;
                }
            }
        }
    }

}
