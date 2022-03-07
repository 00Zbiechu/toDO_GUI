package pliki.todo_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditController {

    //FXML
    @FXML
    private TextField numberOfAction;

    @FXML
    private TextField content;

    @FXML
    private TextField hour;

    @FXML
    private TextField minutes;

    @FXML
    private Label message;


    //Var
    private byte editNumber;
    private String editActionContent;
    private String editActionHour;
    private String editActionMinutes;


    //Number SET & GET
    public void setEditNumber(byte editNumber){
        this.editNumber=editNumber;
    }
    public byte getEditNumber() {return editNumber;}

    //Content SET & GET
    public void setEditActionContent(String contentOfAction){
        editActionContent=contentOfAction;
    }
    public String getEditActionContent(){return editActionContent;}

    //Hour SET & GET
    public void setEditActionHour(String HourOfAction){
        editActionHour=HourOfAction;
    }
    public String getEditActionHour() {return editActionHour;}

    //Minutes SET & GET
    public void setEditActionMinutes(String MinutesOfAction){
        editActionMinutes=MinutesOfAction;
    }
    public String getEditActionMinutes() {return editActionMinutes;}




    public void editAction(ActionEvent event){

        try {

                if(Integer.parseInt(numberOfAction.getText())>-1 && Integer.parseInt(numberOfAction.getText())<10) {
                    setEditNumber((byte) Integer.parseInt(numberOfAction.getText()));

                    if ((content.getText().length()) < 20 && content.getText().length() > 0) {
                        setEditActionContent(content.getText());

                        if (Integer.parseInt(hour.getText()) < 24 && Integer.parseInt(hour.getText()) > 0 && hour.getText().length() > 0) {
                            setEditActionHour(hour.getText());

                            if (Integer.parseInt(minutes.getText()) > -1 && Integer.parseInt(minutes.getText()) < 60 && minutes.getText().length() > 0) {
                                setEditActionMinutes(minutes.getText());


                                Node node = (Node) event.getSource();
                                //GUI
                                Stage stage = (Stage) node.getScene().getWindow();
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

                } else {
                    message.setText("Numer akcji musi się mieścić w zakresie [0-9]");
                }

        }catch (Exception e){
            message.setText("Coś poszło nie tak...");
        }


    }

}
