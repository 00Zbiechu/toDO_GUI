package pliki.todo_gui;

import javafx.fxml.FXML;


import javafx.event.ActionEvent;

import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class AddController{

    //FXML
    @FXML
    TextField content;

    @FXML
    TextField hour;

    @FXML
    TextField minutes;

    @FXML
    Label message;

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




    public void addAction(ActionEvent event){

            try {
                if ((content.getText().length()) < 20 && content.getText().length() > 0) {
                    setNewActionContent(content.getText());

                    if (Integer.parseInt(hour.getText()) < 24 && Integer.parseInt(hour.getText()) > 0 && hour.getText().length() > 0) {
                        setNewActionHour(hour.getText());

                        if (Integer.parseInt(minutes.getText()) > -1 && Integer.parseInt(minutes.getText()) < 60 && minutes.getText().length() > 0) {
                            setNewActionMinutes(minutes.getText());


                            node = (Node) event.getSource();
                            stage = (Stage) node.getScene().getWindow();
                            stage.close();


                        } else {
                            message.setText("Minuty nie mieszczą się w zakresie");
                        }

                    } else {
                        message.setText("Godzina nie mieści się w zakresie");
                    }

                } else {
                    message.setText("Treść zawiera nieprzepisową ilość znaków");
                }
            }catch (Exception e){
                message.setText("Coś poszło nie tak...");
            }

    }

}
