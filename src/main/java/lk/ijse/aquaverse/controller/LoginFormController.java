package lk.ijse.aquaverse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.aquaverse.DBConnection;
import lk.ijse.aquaverse.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {

    
    public javafx.scene.control.TextField txtPassword;
    public TextField txtUserName;
    public AnchorPane loginPane;

    public AnchorPane bodyPane;


    public void LoginFormOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText ();
        String password=txtPassword.getText ();

        try {
            User user = checkAuthentication(userName, password);

            if (user!=null){
                //login Success and navigate
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
                stage.show();

                Stage stage2 = (Stage) loginPane.getScene().getWindow();
                stage2.close();
            }else{
                //alert Message
                new Alert(Alert.AlertType.WARNING,"INVALID USER NAME OR PASSWORD..").show ();
                txtUserName.clear();
                txtPassword.clear();
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            //throw new RuntimeException(e);
        }

    }

    public User checkAuthentication(String userName,String password) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getConnection ();
        PreparedStatement pstm = connection.prepareStatement ("SELECT * FROM user WHERE username=? && userPass=?");
        pstm.setObject (1,userName);
        pstm.setObject (2,password);

        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
              return new User(rst.getString(1),rst.getString(2));
        }
        return  null;
    }


    public void btnForgetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ForgotPasswordForm.fxml"))));
        stage.show();

        Stage stage2 = (Stage) loginPane.getScene().getWindow();
        stage2.close();
    }

    public void btnCreateAccountOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterFormOne.fxml"))));
        stage.show();

        Stage stage2 = (Stage) loginPane.getScene().getWindow();
        stage2.close();
    }
}
