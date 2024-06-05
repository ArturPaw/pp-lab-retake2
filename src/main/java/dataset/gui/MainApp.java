package dataset.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        VBox root = FXMLLoader.load(getClass().getResource("/main_view.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Data Set Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
