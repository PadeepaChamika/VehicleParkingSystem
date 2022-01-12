package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane loginAnchorPaneContext;
    public TextField userName;
    public PasswordField password;

    public void onCancel(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) loginAnchorPaneContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingSystemForm.fxml"))));
    }

    public void onLogin(ActionEvent actionEvent) throws IOException {
        if (userName.getText().equalsIgnoreCase("User") && password.getText().equals("1234")) {
            URL resource = getClass().getResource("../view/ParkingSystemDetailsFrom.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginAnchorPaneContext.getScene().getWindow();
            window.setScene(new Scene(load));
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..Wrong input", ButtonType.CLOSE).show();
        }
    }

    public void moveToPassword(ActionEvent actionEvent) {
        password.requestFocus();
    }

}
