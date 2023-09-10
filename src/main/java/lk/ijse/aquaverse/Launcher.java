package lk.ijse.aquaverse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/Login-form.fxml"));

        Scene scene= new Scene(rootNode);
        stage.setTitle("Aqua Verse");
        stage.centerOnScreen();
        stage.setScene(scene);

        stage.show();
    }
}
