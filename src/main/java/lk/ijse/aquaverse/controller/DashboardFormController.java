package lk.ijse.aquaverse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class DashboardFormController {

    public JFXButton btnHome;
    public AnchorPane bodyPane;

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/MainDashboardForm.fxml"))));
    }

    public void btnProcessControlOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/ProcessControlForm.fxml"))));
    }

    public void btnEmployeeManagementOnAction(ActionEvent actionEvent) {
    }
}
