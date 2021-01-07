/*
*
* Given a non-empty array of integers, return the third maximum number in this array.
* If it does not exist, return the maximum number. The time complexity must be in O(n).
* 
* */

public class ArraysSolution {

    public static void main(String[] args) {
        ArraysSolution t = new ArraysSolution();
        int[] arr1 = {1,-2147483648,2};
        int[] arr2 = {2,2,3,1};
        int[] arr3 = {2,1};
        System.out.println("Max value for arr1: " + t.thirdMax1(arr1));
        System.out.println("Max value for arr2: " + t.thirdMax1(arr2));
        System.out.println("Max value for arr3: " + t.thirdMax1(arr3));

        System.out.println("Max value for arr1: " + t.thirdMax2(arr1));
        System.out.println("Max value for arr2: " + t.thirdMax2(arr2));
        System.out.println("Max value for arr3: " + t.thirdMax2(arr3));
/*        arr = new int[] {3,2,1};
        System.out.println("Number of students which need to change places: " + t.heightChecker2(arr));*/
        }

    /*
    * Runtime: 0 ms
    * Memory Usage: 39.6 MB
    **/
    public int thirdMax1(int[] nums) {
        if (nums == null || nums.length <1) return 0;
        int max=Integer.MIN_VALUE, max2=max, max3=max, uniqueCounts=0;
        for (int n : nums) {
            if (uniqueCounts < 2) {
                if (uniqueCounts == 0) {
                    max = n;
                    uniqueCounts++;
                } else if (uniqueCounts == 1) {
                    if (n > max) {
                        max2 = max;
                        max = n;
                        uniqueCounts++;
                    } else if (n < max) {
                        max2 = n;
                        uniqueCounts++;
                    }
                }
            } else if (n > max) {
                max3 = max2;
                max2 = max;
                max = n;
                uniqueCounts++;
            } else if (n > max2 && n < max) {
                max3 = max2;
                max2 = n;
                uniqueCounts++;
            } else if (n >= max3 && n < max2) {
                max3 = n;
                uniqueCounts++;
            }
        }
        return uniqueCounts >= 3 ? max3 : max;
    }

    /*
    * Runtime: 1 ms
    * Memory Usage: 41.2 MB
    * */
    public int thirdMax2(int[] nums) {
        if (nums == null || nums.length <1) return 0;
        long max=Long.MIN_VALUE, max2=max, max3=max;
        for (int n : nums) {
            if (n > max) {
                max3 = max2;
                max2 = max;
                max = n;
            } else if (n > max2 && n < max) {
                max3 = max2;
                max2 = n;
            } else if (n > max3 && n < max2) {
                max3 = n;
            }
        }
        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max;
    }

    public int thirdMax3(int[] nums) {
        long max=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for (int n : nums) {
            if (n >= max) {
                if (n!=max) {
                    max3 = max2;
                    max2 = max;
                    max = n;
                }
            } else if (n >= max2) {
                if (n!=max2) {
                    max3 = max2;
                    max2 = n;
                }
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max;
    }

    int removeDuplicates(int[] nums) {
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

    /*
    Given an array arr of integers, check if there exists two integers N and M such
    that N is the double of M ( i.e. N = 2 * M).

    104 / 104 test cases passed.
    Status: Accepted
    Runtime: 1 ms
    Memory Usage: 39 MB
    */
    boolean checkIfExist1(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        java.util.Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (java.util.Arrays.binarySearch(arr, i+1, arr.length, arr[i]/2) >= 0) return true;
            }
            if (java.util.Arrays.binarySearch(arr, i+1, arr.length, arr[i]*2) >= 0) return true;
        }
        return false;
    }

}
