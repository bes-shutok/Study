import java.util.Arrays;

// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
public class MergeArrays {

    public static void main(String[] args) {
        MergeArrays t = new MergeArrays();
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        t.merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }

    void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Last = m - 1, nums2Last = n -1;
        for (int t=m+n-1; t >= 0; t--) {
            if (nums1Last >= 0 && nums2Last >=0) {
                if (nums1[nums1Last] < nums2[nums2Last]) {
                    nums1[t] = nums2[nums2Last--];
                } else {
                    nums1[t] = nums1[nums1Last--];
                }
            } else if (nums1Last >= 0) {
                nums1[t] = nums1[nums1Last--];
            } else if (nums2Last >= 0) {
                nums1[t] = nums2[nums2Last--];
            }
        }
    }
}
