import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Addres {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(selectMail("SELECT * FROM user.user_info"));
    }

    public static String selectMail(String select) {
        User viktar_P = new User();
        String url = "jdbc:mysql://localhost:3306/user?useSSL=false&useUnicode=true&serverTimezone=UTC";
        String user = "root";
        String password = "Asusx54c";
        String mail = null;
        String query = select;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                viktar_P.setId(Integer.parseInt(rs.getString(1)));
                viktar_P.setName(rs.getString(2));
                viktar_P.setLogin(rs.getString(3));
                viktar_P.setPassword(rs.getString(4));
                viktar_P.setE_mail(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        mail = viktar_P.getE_mail();
        return mail;
    }
}