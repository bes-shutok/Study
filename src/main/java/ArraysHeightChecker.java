import java.util.Arrays;

/*
*
* Students are asked to stand in non-decreasing order of heights for an annual photo.
* Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
* Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
* 
* */

public class ArraysHeightChecker {

    public static void main(String[] args) {
        ArraysHeightChecker t = new ArraysHeightChecker();
        int[] arr = {1,1,4,2,1,3};
        System.out.println("Number of students which need to change places: " + t.heightChecker1(arr));
        arr = new int[] {1,1,4,2,1,3};
        System.out.println("Number of students which need to change places: " + t.heightChecker2(arr));
        }

    /*
    * Runtime: 1 ms
    * Memory Usage: 37.2 MB
    *  */
    public int heightChecker1(int[] heights) {
        if (heights == null || heights.length <= 1) return 0;
        int cap = heights.length, difs = 0;
        int[] copy = new int[cap];
        for (int i=0; i < cap; i++) {
            copy[i] = heights[i];
        }
        Arrays.sort(copy);
        for (int i=0; i < cap; i++) {
            if (copy[i] != heights[i]) difs++;
        }
        return difs;
    }

    /*
    * Runtime: 0 ms
    * Memory Usage: 37.6 MB
    * */
    public int heightChecker2(int[] heights) {
        if (heights == null || heights.length <= 1) return 0;
        int cap = heights.length, difs = 0;
        int[] sorted = new int[cap];
        int[] range = new int[101];

        for (int h: heights) {
            ++range[h];
        }

        for (int i=1, j = 0; i < 101; i++) {
            while (range[i]-- > 0) {
                sorted[j++] = i;
            }
        }
        for (int i=0; i < cap; i++) {
            if (sorted[i] != heights[i]) difs++;
        }
        return difs;
    }
}
