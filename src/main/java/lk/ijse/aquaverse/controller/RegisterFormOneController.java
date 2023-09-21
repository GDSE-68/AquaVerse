package lk.ijse.aquaverse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterFormOneController {
    public AnchorPane registerOnePane;
    public TextField txtName;
    public TextField txtEmail;

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {

        String usr = txtName.getText();
        String pass = txtEmail.getText();

        if (usr.isEmpty() && pass.isEmpty()){
            new Alert(Alert.AlertType.WARNING,"SOMETHING WENT WRONG....").show();

        }else {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterFormTwo.fxml"))));
            stage.show();

            Stage stage2 = (Stage) registerOnePane.getScene().getWindow();
            stage2.close();
        }


     }
}
