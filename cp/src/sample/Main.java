package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Решение систем уравнений методом итераций");
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
