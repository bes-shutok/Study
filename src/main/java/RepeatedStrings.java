import java.io.*;
import java.util.*;

public class RepeatedStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] word = s.toCharArray();
        int numberInWord=0, wordLength=word.length;
        long count=0;
        if (n >= wordLength) {
            for (int i=0; i < wordLength; i++) {
                if (word[i] == 'a') {
                    numberInWord++;
                }
            }

            // The order is very important here!!
            count=(n/wordLength)*numberInWord;
        }
        for (int i=0; i < n % wordLength; i++) {
            if (word[i] == 'a') count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq";
        long n = 549382313570L;
        System.out.println(repeatedString(s,n));

        // 16481469408

/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
