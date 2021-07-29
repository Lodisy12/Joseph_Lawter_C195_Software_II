package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // JDBC URL parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String address = "//wgudb.ucertify.com/WJ07pEt";


    // complete JDBC URL
    private static final String jdbcURL = protocol + vendorName + address;

    // Driver interface reference ??
    private static final String mySqlJdbcDriver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;

    // Username
    private static final String username = "U07pEt";

    // Password
    private static final String password = "53689095345";

    public static Connection startConnection(){
        try {
            Class.forName(mySqlJdbcDriver);
            conn = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("connection successful!");
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(){
        try{
            conn.close();
            System.out.println("Connection Closed!");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

}
