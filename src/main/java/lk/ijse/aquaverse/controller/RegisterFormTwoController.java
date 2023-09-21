package lk.ijse.aquaverse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterFormTwoController {
    public TextField txtUserName;
    public PasswordField txtPassWord;
    public PasswordField txtConfirmPass;
    public AnchorPane registerTwoPane;

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        String usr = txtUserName.getText();
        String pass = txtPassWord.getText();
        String confirmPass = txtConfirmPass.getText();

        if (usr.isEmpty() && pass.isEmpty() && confirmPass.isEmpty()){
            new Alert(Alert.AlertType.WARNING,"SOMETHING WENT WRONG").show();
        }else {
            if (pass.equals(confirmPass)){
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterFormThree.fxml"))));
                stage.show();

                Stage stage2 = (Stage) registerTwoPane.getScene().getWindow();
                stage2.close();
            }else {
                new Alert(Alert.AlertType.WARNING,"RE ENTER PASSWORD.....").show();
            }
        }
    }
}
