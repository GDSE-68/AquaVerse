package lk.ijse.aquaverse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/aquaVerse","root","Ijse1234");
        }
        return connection;
    }

}
