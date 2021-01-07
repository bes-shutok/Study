import org.json.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ExternalXxe {
    public static ArrayList<JSONObject> parseUpload(String xmlData) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://xxe_mysql:3306/PhonebookApp?useSSL=false","root","letmein");
            Statement stmt=con.createStatement();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(xmlData)));

            doc.getDocumentElement().normalize();

            String username;
            ArrayList<JSONObject> results = new ArrayList<JSONObject>();

            NodeList nList = doc.getElementsByTagName("User");

            for (int i = 0; i < nList.getLength(); i++) {
                Node user = nList.item(i);
                if (user.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element)user;
                    username = el.getElementsByTagName("Name").item(0).getTextContent();

                    ResultSet rs = stmt.executeQuery("SELECT name, email, phone FROM tbl_user WHERE name LIKE '%" + username + "%'");

                    JSONObject result = new JSONObject();
                    ArrayList<JSONObject> nameResults = new ArrayList<JSONObject>();

                    result.put("name", username);

                    if (rs.next() == false) {
                        result.put("error", "No results found for " + username);
                        results.add(result);
                    } else {
                        do {
                            JSONObject nameResult = new JSONObject();
                            nameResult.put("name", rs.getString("name"));
                            nameResult.put("email", rs.getString("email"));
                            nameResult.put("phone", rs.getString("phone"));
                            nameResults.add(nameResult);
                            result.put("results", nameResults);
                            results.add(result);
                        } while (rs.next());
                    }

                }
            }
            con.close();
            return results;
        } catch(Exception e) {
            throw e;
        }
    }

}
