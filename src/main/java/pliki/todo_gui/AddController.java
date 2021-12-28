package pliki.todo_gui;

import javafx.fxml.FXML;


import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.scene.control.TextField;



public class AddController{

    //FXML
    @FXML
    TextField content;

    @FXML
    TextField hour;

    @FXML
    TextField minutes;

    //GUI
    Stage stage;
    Node node;


    //Var
    String newActionContent;
    String newActionHour;
    String newActionMinutes;


    //Content SET & GET
    public void setNewActionContent(String contentOfAction){
        newActionContent=contentOfAction;
    }
    public String getNewActionContent() {return newActionContent;}

    //Hour SET & GET
    public void setNewActionHour(String HourOfAction){
        newActionHour=HourOfAction;
    }
    public String getNewActionHour() {return newActionHour;}

    //Minutes SET & GET
    public void setNewActionMinutes(String MinutesOfAction){
        newActionMinutes=MinutesOfAction;
    }
    public String getNewActionMinutes() {return newActionMinutes;}




    public void addAction(ActionEvent event) throws IOException {

        setNewActionContent(content.getText());
        setNewActionHour(hour.getText());
        setNewActionMinutes(minutes.getText());

        node = (Node)event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

}
