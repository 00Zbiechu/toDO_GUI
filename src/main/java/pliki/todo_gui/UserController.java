package pliki.todo_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.scene.control.TextField;


public class UserController {

    //FXML
    @FXML
    private TextField userName;


    //Must be created, to be closed if user will write correct answer
        private final Stage forErrorStage = new Stage();

    //Var
    String name;




    //Set
    public void setUserName(String nameOfUser){
        name=nameOfUser;
    }





    public void confirmTheName(ActionEvent event) throws IOException {

       setUserName(userName.getText());

        Scene scene;
        Parent root;
        if(name.length()>20){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewFail.fxml"));
            root = loader.load();
            scene = new Scene(root);
            forErrorStage.setScene(scene);
                forErrorStage.setResizable(false);
                forErrorStage.setTitle("Błąd");
                forErrorStage.setAlwaysOnTop(true);
            forErrorStage.show();

            FailController failController = loader.getController();
            failController.reasonOfFail("Zbyt długa/krótka nazwa użytkownika [max 20 znaków]");


        }else{

            forErrorStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewDate.fxml"));
            root = loader.load();
            scene = new Scene(root);
            Node node = (Node) event.getSource();
            //GUI
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            DateController dateController = loader.getController();
            dateController.displayName(name);


        }


    }





}