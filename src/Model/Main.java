package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.DBQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
Java Docs are located at Joseph_Lawter_C195_Software_II\javadoc
 */

/**
 * This is the main class where the main method lies.
 * @author Joseph Lawter
 *
 */
public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../scenes/loginScreen.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 450, 300));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
        //Locale.setDefault(new Locale("fr"));

        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO countries(Country, Create_Date," +
                " Created_By, Last_Updated_By) " +
                "Values(?,?,?,?)";

//        DBQuery.setPreparedStatement(conn);
//        Statement statement = DBQuery.getPreparedStatement();
//        String country, createDate, createdBy, lastUpdateBy;
//        String selectStatement = "SELECT * FROM countries " +
//                "WHERE Created_By = 'admin'";
//        country = "'Narnia'";
//        createDate = ", '2021-07-29 00:00:00'";
//        createdBy = ", 'admin'";
//        lastUpdateBy = ", 'admin'";
//        String insertStatement = "INSERT INTO countries(Country, Create_Date" +
//                ", Created_By, Last_Updated_By) " +
//                "VALUES(" + country
//                + createDate +
//                createdBy +
//                lastUpdateBy + ")";
//
//        try {
//            statement.execute(insertStatement);
//            ResultSet results = statement.getResultSet();
//            if(statement.getUpdateCount() > 0){
//                System.out.println(statement.getUpdateCount() + " row(s) affected");
//            }
//            else{
//                System.out.println("No rows affected");
//            }
//
//
////            while (results.next()) {
////                int countryId = results.getInt("Country_ID");
////                String countryName = results.getString("Country");
////                String createdBy = results.getString("Created_by");
////                LocalDate date = results.getDate("Create_Date").toLocalDate();
////                LocalTime time = results.getTime("Create_Date").toLocalTime();
////                LocalDateTime lastUpdate = results.getTimestamp("Last_Update").toLocalDateTime();
////                String updatedBy = results.getString("Last_Updated_By");
////                System.out.println(countryId + " " + countryName + " " + createdBy
////                        + " " + date + " " + time + " " + lastUpdate);
////            }
//        }
//        catch (SQLException e){
//            System.out.println(e);
//        }

        launch(args);
        DBConnection.closeConnection();
    }
}