package pliki.todo_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage){

        try {

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ViewUsername.fxml"));
            Scene scene = new Scene(loader.load());
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