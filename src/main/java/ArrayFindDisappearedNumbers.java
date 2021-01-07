import java.util.ArrayList;
import java.util.List;

/*
*
* Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
* Find all the elements of [1, n] inclusive that do not appear in this array.
* Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
* 
* */

public class ArrayFindDisappearedNumbers {

    public static void main(String[] args) {
        ArrayFindDisappearedNumbers t = new ArrayFindDisappearedNumbers();
        int[] arr1 = {1, 1, 2};
        int[] arr2 = {2, 2, 3, 1};
        int[] arr3 = {2,3,4,5,6,7,8,1};
        System.out.println("Missing values in arr1: " + t.findDisappearedNumbers1(arr1));
        System.out.println("Missing values in arr2: " + t.findDisappearedNumbers1(arr2));
        System.out.println("Missing values in arr3: " + t.findDisappearedNumbers1(arr3));

        arr1 = new int[] {1, 1, 2};
        arr2 = new int[] {2, 2, 3, 1};
        arr3 = new int[] {2,3,4,5,6,7,8,1};

        System.out.println("Missing values in arr1: " + t.findDisappearedNumbers2(arr1));
        System.out.println("Missing values in arr2: " + t.findDisappearedNumbers2(arr2));
        System.out.println("Missing values in arr3: " + t.findDisappearedNumbers2(arr3));
        
        arr1 = new int[] {1, 1, 2};
        arr2 = new int[] {2, 2, 3, 1};
        arr3 = new int[] {2,3,4,5,6,7,8,1};
        System.out.println("Missing values in arr1: " + t.findDisappearedNumbers3(arr1));
        System.out.println("Missing values in arr2: " + t.findDisappearedNumbers3(arr2));
        System.out.println("Missing values in arr3: " + t.findDisappearedNumbers3(arr3));
    }


    /*
     * Runtime: 9 ms
     * Memory Usage: 63.9 MB
     * */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) return result;
        int cap = nums.length;
        int[] counts = new int[cap];
        for (int i = 0; i < cap; i++) {
            ++counts[nums[i]-1];
        }
        for (int i = 0; i < cap; i++) {
            if (counts[i] == 0) result.add(i+1);
        }
        return result;
    }

    /*
     * Runtime: 5 ms
     * Memory Usage: 49.4 MB
     * */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) return result;
        int cap = nums.length, index;
        for (int i = 0; i < cap; i++) {
            index = Math.abs(nums[i])-1;
            if(nums[index] > 0) nums[index] = - nums[index];
        }
        for (int i = 0; i < cap; i++) {
            if (nums[i] > 0) result.add(i+1);
        }
        return result;
    }

    /*
     * Runtime: 5 ms
     * Memory Usage: 48.4 MB
     * */
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length < 2) return result;
        int cap = nums.length;
        boolean[] indices = new boolean[cap];
        for (int i = 0; i < cap; i++) {
            indices[nums[i]-1]=true;
        }
        for (int i = 0; i < cap; i++) {
            if (!indices[i]) result.add(i+1);
        }
        return result;
    }
}
