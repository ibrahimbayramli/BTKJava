import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName="postgres";
    private String password="163264";
    private String dbUrl="jdbc:postgresql://localhost:5432/DvdRental";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showErrorMessage(SQLException e){
        System.err.println("Error : "+e.getMessage());
        System.err.println("Error code : "+e.getErrorCode());

    }


}
