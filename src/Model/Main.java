package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;
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
        Locale.setDefault(new Locale("fr"));
        Parent root = FXMLLoader.load(getClass().getResource("../scenes/login_screen.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 450, 300));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args);}
}