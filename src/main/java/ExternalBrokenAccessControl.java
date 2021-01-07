
import java.sql.*;
import java.util.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.sql.*;
import java.util.*;

import org.json.JSONObject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;


public class ExternalBrokenAccessControl {

    public static HashMap<String, String> accountLookup(String accountId, String jwt) throws Exception{

        if (jwt == null) { ;
            throw new LoggedOutException("User is not logged in");
        } else {

            Claims claims = Jwts.parser()
                                .setSigningKey("luBEK(P$x[%ZeQ4HAD5Ji1Z*;0Gcz583yP!v|KCmNEDDmQF/9P)>GpJK>Cx}3;R".getBytes("UTF-8"))
                                .parseClaimsJws(jwt).getBody();

            if ((claims.get("logged_in")).toString().equals("true")) {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/BankApp?useSSL=false", "root", "letmein");

                Statement stmt = con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT username FROM tbl_user WHERE id = '" + accountId + "';");

                if (!rs.next()) {
                    con.close();
                    throw new Exception("Account not found");
                }

                String user = new String();
                user = rs.getString("username");
                HashMap<String, String> results = new HashMap<String, String>();

                if ((claims.get("username")).toString().equals(user)) {
                    rs = stmt.executeQuery("SELECT balance, dob FROM tbl_account WHERE user_id = '" + accountId + "';");

                    if (rs.next()) {
                        results.put("balance", rs.getString("balance").toString());
                        results.put("dob", rs.getString("dob").toString());
                        results.put("username", user);

                    }
                    con.close();
                } else {
                    con.close();
                    throw new Exception("Access denied");
                }
                con.close();

                return results;
            } else {
                throw new LoggedOutException("User is not logged in");
            }
        }
    }


    private static class LoggedOutException extends Exception {
        public LoggedOutException(String user_is_not_logged_in) {}
    }

}
