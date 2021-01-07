import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HashSetFunctions {
    int steps = 1000;
    List<Integer> digits = new ArrayList<>();

    /*
    * Runtime: 17 ms
    * Memory Usage: 38.7 MB
    * */
    public boolean isHappy(int n) {
        if (happyStep(n) == 0) return false;
        return true;
    }

    private int happyStep(int n) {
        if (steps-- < 1) return 0;
        if (n <= 1) return n;
        int sum = 0;
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        for (Integer d : digits) {
            sum+= d*d;
        }
        digits.clear();
        return sum <= 1 ? sum : happyStep(sum);
    }

    /*
    * Runtime: 1 ms
    * Memory Usage: 36.2 MB
    * */
    public boolean isHappy2(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n > 1) {
            n = getSum(n);
            if (seen.contains(n)) return false;
            seen.add(n);
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    /*
    * Runtime: 6 ms
    * Memory Usage: 39.3 MB
    * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> numSet2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        numSet1.retainAll(numSet2);
        return numSet1.stream().mapToInt(Integer::intValue).toArray();
    }


    /*
     * Runtime: 5 ms
     * Memory Usage: 39.3 MB
     * */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>(), numSet2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) numSet1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) numSet2.add(nums2[i]);
        numSet1.retainAll(numSet2);
        return numSet1.stream().mapToInt(Integer::intValue).toArray();
    }


    /*
     * Runtime: 4 ms
     * Memory Usage: 39.2 MB
     * */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>(), numSet2 = new HashSet<>(), intersection = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) numSet1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) numSet2.add(nums2[i]);
        for (int i = 0; i < nums1.length; i++) if(numSet2.contains(nums1[i])) intersection.add(nums1[i]);
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }


    /*
     * Runtime: 2 ms
     * Memory Usage: 39 MB
     * */
    public int[] intersection4(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>(), numSet2 = new HashSet<>(), intersection = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) numSet1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) numSet2.add(nums2[i]);
        for (int i = 0; i < nums1.length; i++) if(numSet2.contains(nums1[i])) intersection.add(nums1[i]);
        int[] result = new int[intersection.size()];
        int idx=0;
        for (int x: intersection) result[idx++] = x;
        return result;
    }
}
