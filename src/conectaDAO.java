import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection connectDB() {

        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:3306/uc11";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ConectaDAO " + e);

        }

        return conn;
    }
}