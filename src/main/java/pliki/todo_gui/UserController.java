package pliki.todo_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class UserController {

    @FXML
    TextField userName;

    @FXML
    Text message;

    Stage stage;
    Scene scene;
    Parent root;
    Node node;


    public void confirmTheName(ActionEvent event) throws IOException {

        String name = userName.getText();

        if(name.length()>20){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewFail.fxml"));
            root = loader.load();
            scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Błąd");
            stage.setAlwaysOnTop(true);
            stage.show();

            FailController failController = loader.getController();
            failController.reasonOfFail("Zbyt długa nazwa użytkownika [max 20 znaków]");


        }else{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewDate.fxml"));
            root = loader.load();
            scene = new Scene(root);
            node = (Node)event.getSource();
            stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            DateController dateController = loader.getController();
            dateController.displayName(name);

        }


    }



}