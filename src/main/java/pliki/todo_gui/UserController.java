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
    TextField userName;


    //GUI
        Stage stage;
        //Must be created, to be closed if user will write correct answer
        Stage forErrorStage = new Stage();
        Scene scene;
        Parent root;
        Node node;

    //Var
    String name;


    //Set & GET
    public void setUserName(String nameOfUser){
        name=nameOfUser;
    }

    public String getUserName(){
        return  name;
    }




    public void confirmTheName(ActionEvent event) throws IOException {

       setUserName(userName.getText());

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
            failController.reasonOfFail("Zbyt długa lub zbyt krótka nazwa użytkownika [max 20 znaków]");


        }else{

            forErrorStage.close();

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