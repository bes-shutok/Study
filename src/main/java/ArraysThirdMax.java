/*
*
* Given a non-empty array of integers, return the third maximum number in this array.
* If it does not exist, return the maximum number. The time complexity must be in O(n).
* 
* */

public class ArraysThirdMax {

    public static void main(String[] args) {
        ArraysThirdMax t = new ArraysThirdMax();
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


    
/*    public int thirdMax(int[] nums) {
        if (nums == null || nums.length <1) return 0;
        int cap = nums.length;
        int max=Integer.MIN_VALUE, max2=max, max3=max;
        for (int i=1; i < cap; i++) {
            if (nums[i] > max) {
                max3 = max2;
                max2 = max;
                max = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        System.out.println(max + " " + max2+ " " + max3);
        return ((max3 < max2) && (max2 < max)) ? max3 : max;
    }*/
}
