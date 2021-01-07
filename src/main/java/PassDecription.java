import io.jsonwebtoken.lang.*;

import java.io.*;
import java.util.*;

public class PassDecription {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
        String result="";
        char c;
        char[] pass =s.toCharArray();
        int i=0, inputLength=pass.length;
        Stack<Integer> numbers = new Stack<Integer>();
        c = pass[i++];
        while (i < inputLength/2 && Character.isDigit(c)) {
            numbers.push(Character.getNumericValue(c));
            c = pass[i++];
        }
        if (i > 0) { i--;}
        while (i< inputLength) {
            c = s.charAt(i++);
            if (Character.isDigit(c) && c =='0' && !numbers.isEmpty()) {
                result += numbers.pop();
            } else if (i + 1 < inputLength && Character.isUpperCase(c)
                    && Character.isLowerCase(pass[i]) && pass[i + 1] == '*') {
                result += "" + pass[i] + c;
                i+=2;
            } else {result += "" + c;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String t6 =
                "SCbGySlvypJTpLejFrCokBdbkFwvoBdotGKJwWYsBQqZlVnBOAPzGYBbPldRIiDvIVsvOUIxrSubxsdeuhxZGnplrTIpMPzYxjtZdkvcZqKiZbyNAbSMhNXdzsJJAuPsySbzyvlYdGjxEphHpSsfnpICjVzLGdUSJTclbixxUJimOGKcFbNWfRxBeKAPFqzLcVFmYERHqtnGWcTVOWvUfZyePtrqDuAgjYTggmYwgNyNkwOcRIaAPdpaOKbNnYdQiDajxUoVdSUvtkijAbseydJSKRhRRVVgugJiOSVHzHLgbUxKpTAycqIXwbXRkXAGtQKwotpmNfDtOFsDYcFtKpqWVFgdZOazlRQRKgCEmxSeWgYfBaoIiqlkNxmaxZWrrujwpdKKaYLpphfigftyyopuvpjpYWBFLtCFzaFgRDwvxijgeJkzOvlWJrClqUSRMMGSccCfCnXawgtGVHXDAaDPCKAWtVIGjMttcAUHFvFDicjdTlWebbgduAmyWwhOSBEURSuHZTthvxwFAaGmYMPvCRrxJzLTNyoRUrozhiCHwLxFNeSNVIZnAdDPnrbvjtoyjZQSSTuygzdZMiVDAFfeLEmFyvkotscjbFuqkiVohPzcizfiWyYbrbFoEGDZqKyAfFNyqghPBnNoMSxTxLcSGqsLlEhMqBakmAQCOwxltSXHUcYFxrGDgKskVCvyNKtEZVNQCVWTaDWSKWpFerDbjQJlRpvZFKJNXtFUMxMoEaRDgnNgMKcWNHhZmZaNLEjvdBvPVYWDDhkaqDGzpLRCWjkHKCyNJPHayFLxrDIIlHIdkWjVoSIxCDRNZNTJCsYTcYhfWNaSiUOtMbTLDfIiemxgrOlBMLccYYyUakJhKsxUgdSlzTewhiEmZYqHEjXgngrcFyBpeoiPPnLNlUyeHYcWyuKhXMvvKDmNBwcuNjykrKGgCBZoDhhSfmbLWKzSAXSjOtZAZWwHDeTLANxNzAKiOoADLFqAlPhsUVSDytavisgIVoclIUaaQoiOu";
        String t9 =
                "67121249883339433563625841111176119195186878625328541683976155838189995411546452765321212936485289563186712423728596122453722275212824811377547764619152997917589966292172694417836385922434128226797985211377627263967962528743842736915681769896615715253214644832423511189887336519623397367596812663518323316841574234147764311477287136137927171999668662758913611622598589825586748131179843176416472619544364957278398592146735244698973712833787325299583357243452883526427621142417377543351199572414352899912817797721685134173983255459645682717414644851247872133122313498826533985453354993465188591439813925612534751917349149155782828232772222515423767263718776617151254584791987659872311467911584947473844657586748799816396713687365867474781191645159688325671495996369573144427348876539926485242518796979873928327563589749189181335729372644575174296973122281958617298475297994129223929287171644169195634158779647229768433288633599529488447283375117649763157433649562298925528559839426143979258861271928641181231447476355473193869";



/*        Assert.assertEquals(t6, decryptPassword(t6));
        Assert.assertEquals(t9, decryptPassword(t9));*/

        System.out.println("decryptPassword(t6): " + decryptPassword(t6));
        System.out.println("decryptPassword(t9): " + decryptPassword(t9));
    }
}
