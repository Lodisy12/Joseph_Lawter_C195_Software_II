package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {

    private static Statement preparedStatement; // Statement reference

    // Create Statement Object
public static void setPreparedStatement(Connection conn,
                    String sqlStatement) throws SQLException {
        preparedStatement = conn.prepareStatement(sqlStatement);
    }

    // Return statement object

    public static Statement getPreparedStatement(){
        return preparedStatement;
    }

}
