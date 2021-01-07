import java.io.*;
import java.net.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class testHackerEdu {

/*    *//*
     * Complete the 'getUsernames' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER threshold as parameter.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
     *//*

    public static List<String> getUsernames(int threshold) {

        List<String> result = new ArrayList();

        String baseUrl = "https://jsonmock.hackerrank.com/api/article_users?page=";
        for (int i=1; i <10;i++) {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(baseUrl + i).openConnection();
                con.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                response.toString();
                result.add(con.getInputStream().);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return response.toString();;

    }*/

}