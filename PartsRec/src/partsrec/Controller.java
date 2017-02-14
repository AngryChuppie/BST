package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Label loginlabel;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    public void LoggingIn(ActionEvent event) throws Exception {
            if (txtUsername.getText().equals("melo") && txtPassword.getText().equals("pass")) {
                loginlabel.setText("Login Successful");
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                primaryStage.setTitle("Management System");
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.show();
            } else {
                loginlabel.setText("Login Failed! Try again Later!");
            }
    }
}





