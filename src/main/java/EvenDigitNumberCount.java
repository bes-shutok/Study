// Given an array nums of integers, return how many of them contain an even number of digits.
public class EvenDigitNumberCount {

    static class Test {
        int numberOfDigits(int num) {
            int count = 0;
            if (num == 0) num++;
            while (num > 0) {
                count++;
                num = num / 10;
            }
            return count;
        }


        int findNumbers(int[] nums) {
            int count = 0;
            for (int num : nums) {
                if (numberOfDigits(num) % 2 == 0) count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.findNumbers(new int[]{12,345,2,6,7896}));
    }
}
