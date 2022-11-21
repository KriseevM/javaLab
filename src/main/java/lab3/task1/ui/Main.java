package lab3.task1.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(this.getClass().getResource("mainFrame.fxml")));
        primaryStage.setTitle("Clock Store");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


}
