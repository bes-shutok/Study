import java.io.*;
import java.util.*;

public class MyComparator {
    public static void main(String[] args) throws IOException {
        boolean result;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert number of comparisons:");
        int numberOfCases = scanner.nextInt();
        System.out.println("Number of comparisons: " + numberOfCases);
            for (int i = 0; i < numberOfCases; i++) {
                System.out.println("Insert type of tests: 1 (strings) or 2 (integers), or 3 (array of integers).");
                int typeOfCase = scanner.nextInt();
                switch (typeOfCase) {
                    case 1:
                        result = compare(scanner.next(), scanner.next());
                        break;
                    case 2:
                        result = compare(scanner.nextInt(), scanner.nextInt());
                        break;
                    case 3:
                        int n = scanner.nextInt();
                        int m = scanner.nextInt();
                        result = compare(createArray(scanner, n), createArray(scanner, m));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + args[3 * i - 1]);
                }
                if (result) {
                    System.out.println("Same");
                } else {
                    System.out.println("Different");
                }
            }
        scanner.close();
    }


    static boolean compare(String a, String b) {
        return a.equals(b);
    }

    static boolean compare(int a, int b) {
        return a == b;
    }

    static boolean compare(int[] a, int[] b) {
        return a.equals(b);
    }

    static int[] createArray(Scanner scanner, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return new int[n];
    }

}
