package pliki.todo_gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;
import javafx.scene.control.TextField;



public class UserController {

    @FXML
    TextField userName;
    Label errorCode;


    public void confirmTheName(ActionEvent event) throws IOException {

        String name = userName.getText();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("View2.fxml"));
            Parent root = loader.load();

            DateController dateController = loader.getController();
            dateController.displayName(name);


            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();




    }



}