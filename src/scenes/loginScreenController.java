package scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class loginScreenController {
    public Button login_button;
    public TextField user_name_text_field;
    public TextField password_text_field;
    public Label error_field;
    public Locale Location = Locale.getDefault();
    public Label password_label;
    public Label username_label;


    public void initialize() {
        if (Location.getLanguage().equals("fr")) {
            System.out.println("French!");
            password_label.setText("le mot de passe:");
            username_label.setText("Nom d'utilisateur:");
            user_name_text_field.setPromptText("Nom d'utilisateur");
            password_text_field.setPromptText("Nom d'utilisateur");
            login_button.setText("connexion");
        }
    }

    public void pressButton(javafx.event.ActionEvent actionEvent) throws IOException {
        if (Location.getLanguage().equals("fr")) {
            String username = user_name_text_field.getText();
            String password = password_text_field.getText();
            if (username.equals("Test")) {
                error_field.setText("");
                if (password.equals("Test")) {
                    Parent root = FXMLLoader.load(getClass().getResource(
                            "/scenes/mainScreen.fxml"));
                    Stage stage = (Stage)((Button) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root,850,600);
                    stage.setTitle("second scene");
                    stage.setScene(scene);
                    stage.show();
                    System.out.println("Connexion réussie");
                    error_field.setText("");
                } else {
                    error_field.setText("ERREUR : mot de passe invalide");
                    System.out.println("Mot de passe incorrect");
                }
            } else {
                error_field.setText("ERREUR : nom d'utilisateur invalide");
                System.out.println("Nom d'utilisateur invalide");
            }
        }
        else{
            String username = user_name_text_field.getText();
            String password = password_text_field.getText();
            if (username.equals("Test")){
                error_field.setText("");
                if (password.equals("Test")){
                    System.out.println("Login Successful");
                    error_field.setText("");
                    }
                else{
                    error_field.setText("ERROR: Invalid Password");
                    System.out.println("Invalid Password");
                }
                }
            else {
                error_field.setText("ERROR: Invalid Username");
                System.out.println("Invalid Username");
            }
        }
    }
}
