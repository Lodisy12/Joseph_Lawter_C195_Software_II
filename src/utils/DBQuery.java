package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {

    private static PreparedStatement preparedStatement; // Statement reference

    // Create Statement Object
public static void setPreparedStatement(Connection conn,
                    String sqlStatement) throws SQLException {
        preparedStatement = conn.prepareStatement(sqlStatement);
    }

    // Return statement object

    public static PreparedStatement getPreparedStatement(){
        return preparedStatement;
    }

}
