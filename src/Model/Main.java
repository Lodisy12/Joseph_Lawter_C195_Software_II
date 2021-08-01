package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.DBQuery;

import java.sql.*;
import java.util.Scanner;
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



        launch(args);
        DBConnection.closeConnection();
    }
}