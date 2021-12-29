package pliki.todo_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import java.time.LocalDate;



public class ActivityController {

    //FXML
    @FXML
    Text hello;

    @FXML
    TextArea activityList;

    @FXML
    Label message;


    //GUI
    Stage newStage = new Stage();
    Scene scene;
    Parent root;


    //Var
    public String[] actions= new String[10];
    public byte currentAction = 0;




    public void addToCurrentAction(){

        this.currentAction++;

    }



    public void createEmptyList(){
        for(int i=0;i<10;i++){
            actions[i]=("["+i+"] ---------- [0:0]");
        }
    }

    public void clearList(){
        activityList.clear();
    }

    public void showActions(){
        for(int i=0;i<10;i++) {
            activityList.appendText(actions[i]+"\n");
        }
    }




    public void setWelcome(String name,LocalDate date){
        hello.setText("Witaj użytkowniku "+name+", edytujesz ustawienia dla "+date);
    }



    //ADD Scene
    public void switchAdd() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAdd.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Dodaj aktywność");
            newStage.setAlwaysOnTop(true);
                AddController addController = loader.getController();
                loader.setController(addController);
        newStage.showAndWait();
                addNewAction(addController.getNewActionContent(),addController.getNewActionHour(),addController.getNewActionMinutes());
                clearList();
                showActions();
    }


    //Set & Get
    public void addNewAction(String newActions, String newHour, String newMinute){
        if(currentAction<10){
            actions[currentAction]=("["+currentAction+"] "+newActions+" ["+newHour+":"+newMinute+"]");
            addToCurrentAction();
        }else{
            message.setText("Maksymalna liczba operacji do dodania [10]");
        }
    }




    //Edit Scene
    public void switchEdit() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewEdit.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Edytuj aktywność");
            newStage.setAlwaysOnTop(true);
                EditController editController = loader.getController();
                loader.setController(editController);
        newStage.showAndWait();
                editNewAction(editController.getEditNumber(),editController.getEditActionContent(),editController.getEditActionHour(),editController.getEditActionMinutes());
                clearList();
                showActions();

    }

    //Set & Get
    public void editNewAction(byte number, String newActions, String newHour, String newMinute){
        if(number>-1 && number<10){
            actions[number]=("["+number+"] "+newActions+" ["+newHour+":"+newMinute+"]");
        }else{
            message.setText("Nr wykracza poza zakres zadań [0-9]");
        }
    }




    public String[] getActions(){
        return actions;
    }


}
