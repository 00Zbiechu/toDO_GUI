package pliki.todo_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EditController {

    //FXML
    @FXML
    TextField numberOfAction;

    @FXML
    TextField content;

    @FXML
    TextField hour;

    @FXML
    TextField minutes;

    @FXML
    Label message;


    //Var
    String editNumber;
    String editActionContent;
    String editActionHour;
    String editActionMinutes;


    //Number SET & GET
    public void setEditNumber(String editNumber){
        this.editNumber=editNumber;
    }
    public String getEditNumber() {return editNumber;}

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



    }

}
