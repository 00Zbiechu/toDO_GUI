package pliki.todo_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("View1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("toDO");
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch();

    }

}