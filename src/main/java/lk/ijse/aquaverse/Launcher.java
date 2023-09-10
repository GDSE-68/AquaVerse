package lk.ijse.aquaverse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboardForm.fxml")));

        Scene scene= new Scene(rootNode);
        stage.setTitle("Aqua Verse");
        stage.centerOnScreen();
        stage.setScene(scene);

        stage.show();
    }
}
