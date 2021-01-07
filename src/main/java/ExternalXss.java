import java.sql.*;
import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

public class ExternalXss {
    public static void addComment(String username, String comment) throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://mysql:3306/BlogApp?useSSL=false","root","letmein");

            comment = escapeHtml4(comment);
            comment = username + ": " + comment;

            Statement stmt=con.createStatement();
            String query = "INSERT INTO tbl_comments (comment) VALUES (?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, comment);
            statement.execute();

            con.close();
        } catch(Exception e) {
            throw e;
        }
    }
}
