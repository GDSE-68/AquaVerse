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
    public JFXButton btnEditProfile;
    public JFXButton btnLogOut;
    public JFXButton btnReportsManagement;
    public JFXButton btnStockManagement;
    public JFXButton btnAttendenceManagement;
    public JFXButton btnEmployeeManagement;
    public JFXButton btnProcessControl;

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/MainDashboardForm.fxml"))));
    }

    public void btnProcessControlOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/ProcessControlForm.fxml"))));
    }

    public void btnEmployeeManagementOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/EmployeeManagementForm.fxml"))));
    }

    public void btnAttendenceManagementOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/EmployeeAttendence.fxml"))));
    }

    public void btnStockManagementOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/StockManagementForm.fxml"))));
    }

    public void btnReportsManagementOnAction(ActionEvent actionEvent) throws IOException {
        bodyPane.getChildren().clear();
        bodyPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/ReportManagementForm.fxml"))));
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {

    }

    public void btnEditProfileOnAction(ActionEvent actionEvent) {

    }
}
