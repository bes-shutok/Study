import java.sql.*;

public class External{
    public static boolean addPost(String post, String username) throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/SocialMediaApp?useSSL=false", "root", "letmein");

            /*Statement stmt = con.createStatement();
            String query = "INSERT INTO posts VALUES ('" + post + "','" + username + "');";
            stmt.executeUpdate(query);
            */

            PreparedStatement stmt = con.prepareStatement("INSERT INTO posts VALUES (?,?);");
            stmt.setString(1, post);
            stmt.setString(2, username);
            stmt.executeUpdate();

            con.close();
            return false;
        } catch(Exception e) {
            throw e;
        }
    }
}
