import java.util.Scanner;

class PolynomialWithLoops {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        String[][] resp = new String[t][];
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            resp[i] = polynomialRange(a,b,n);
        }
        in.close();
        for (int i=0; i<t; i++){
            System.out.println(String.join(" ", resp[i]));
        }
    }


    private static String[] polynomialRange(int a, int b, int n) {
        String[] result = new String[n];
        int incrementalPart = a +b, polynomialPart = b;
        result[0] = String.valueOf(incrementalPart);
        for (int i=1; i<n; i++) {
            polynomialPart = polynomialPart * 2;
            incrementalPart = incrementalPart + polynomialPart;
            result[i] = String.valueOf(incrementalPart);
        }
        return result;
    }
}
